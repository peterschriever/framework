package Framework.Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class Connection {
    private int port;
    private String host;
    private Socket serverSocket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public Connection(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        System.out.println("[networking] Connected with: " + this.host + ":" + this.port);
        serverSocket = new Socket(this.host, this.port);

        inputStream = new DataInputStream(serverSocket.getInputStream());
        outputStream = new DataOutputStream(serverSocket.getOutputStream());
    }

    public Response sendRequest(String request) throws IOException, InterruptedException {
        outputStream.write(request.getBytes());
        outputStream.flush();

        return new Response(inputStream);
    }

    public Response sendRequest(String request, final List<String> params) throws IOException, InterruptedException {
        for (String param : params) {
            request += param;
        }
        return sendRequest(request);
    }

}
