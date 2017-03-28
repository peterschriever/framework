package Framework.Networking;

import java.io.*;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public class Response {
    private String responseString;

    public Response(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        responseString = "";
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("[networking] readLine: " + line);
            responseString += line;
        }
    }

    @Override
    public String toString() {
        return responseString;
    }
}
