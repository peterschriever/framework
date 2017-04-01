package Framework.Networking.InputObserver;

import Framework.Config;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.concurrent.TimeoutException;

/**
 * Created by peterzen on 2017-03-29.
 * Part of the framework project.
 */
public class InputStreamReader extends Observable implements Runnable {
    private DataInputStream inputStream;
    private BufferedReader bufferedReader;
    private String responseString;

    public InputStreamReader(InputStream inputStream) throws IOException {
        this.inputStream = new DataInputStream(inputStream);
        this.bufferedReader = new BufferedReader(new java.io.InputStreamReader(this.inputStream, "UTF-8"));
    }

    @Override
    public void run() {
        responseString = "";
        skipLines(2); // skip the copyright and title lines

        while (true) {
            try {
                readLineFromInput();
            } catch (TimeoutException e) {
                handleReadTimeout();
            } catch (IOException e) {
                handleConnectionDrop(e);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void skipLines(int amount) {
        for (int i = 0; i < amount; i++) {
            try {
                bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace(); //@TODO: is there a better way to handle this exception?
            }
        }
    }

    private void handleReadTimeout() {
        if (!responseString.equals("")) {
            System.out.println("notify called: " + responseString);
            notifyObservers(responseString);
            responseString = "";
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e1) {
            e1.printStackTrace(); // @TODO: is there a better way to handle this exception?
        }
    }

    private void handleConnectionDrop(Exception e) {
        // @TODO: decide what to do when the InputStream connection drops (logout/conn problems)
        e.printStackTrace();
    }

    private void readLineFromInput() throws Exception {
        // readLine from server InputStream
        String line = bufferedReader.readLine();
        if (line == null) {
            throw new IOException("InputStream connection dropped"); // InputStream connection dropped
        }

        setChanged();
        notifyObservers(line);
    }
}
