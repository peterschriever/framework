package Framework.Networking;

import Framework.Networking.InputObserver.InputStreamObserver;
import Framework.Networking.InputObserver.InputStreamReader;
import Framework.Networking.Request.Request;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Stack;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class Connection {
    private int port;
    private String host;
    private Socket serverSocket;
    private InputStreamReader inputReader;
    private DataOutputStream outputStream;
    private Thread inputReaderThread;

    public Connection(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        System.out.println("[networking] Connected with: " + this.host + ":" + this.port);

        serverSocket = new Socket(this.host, this.port);
        inputReader = new InputStreamReader(serverSocket.getInputStream());
        outputStream = new DataOutputStream(serverSocket.getOutputStream());
    }

    public void sendRequest(String request) throws IOException, InterruptedException {
        request += "\n";
        outputStream.write(request.getBytes());
        outputStream.flush();
    }

    public void sendRequest(String request, final List<String> params) throws IOException, InterruptedException {
        for (String param : params) {
            request += " " + param;
        }

        sendRequest(request);
    }

    public void setupInputObserver() {
        inputReader.addObserver(new InputStreamObserver());
        inputReaderThread = new Thread(inputReader);
        inputReaderThread.start();
    }
}
