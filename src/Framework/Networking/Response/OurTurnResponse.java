package Framework.Networking.Response;

/**
 * Created by peterzen on 2017-04-01.
 * Part of the framework project.
 */
public class OurTurnResponse implements Response {
    private final String turnMessage;

    public OurTurnResponse(String turnMessage) {
        this.turnMessage = turnMessage;
    }

    @Override
    public void executeCallback() {
        System.out.println("[networking] OurTurnResponse callback not implemented yet");
        System.out.println("\t turnMessage: " + turnMessage);
    }
}
