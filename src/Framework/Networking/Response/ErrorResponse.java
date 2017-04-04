package Framework.Networking.Response;

import Framework.Networking.Request.Request;

/**
 * Created by peterzen on 2017-03-30.
 * Part of the framework project.
 */
public class ErrorResponse implements Response {
    private Request request;

    public ErrorResponse(Request probableCause) {
        this.request = probableCause;
    }

    @Override
    public void executeCallback() {
        System.out.println("[networking] ErrorResponse callback not implemented yet");
    }

    public Request getRequest() {
        return request;
    }
}
