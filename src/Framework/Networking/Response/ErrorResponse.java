package Framework.Networking.Response;

import Framework.Networking.Connection;
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

    public Request getRequest() {
        return request;
    }

    @Override
    public void executeCallback() {
        Connection.getEventHandler().errorReceived(this);
    }
}
