package Framework.Networking.Request;

import Framework.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by peterzen on 2017-03-28.
 * Part of the framework project.
 */
public abstract class Request {
    private static Stack<Request> requestStack;
    private static int maxStackSize;
    private static int preferredStackSize;

    protected Request() {
        requestStack = new Stack<>();
        try {
            maxStackSize = Integer.parseInt(Config.get("network", "requestMaxStackSize"));
            preferredStackSize = Integer.parseInt(Config.get("network", "requestPreferredStackSize"));
        } catch (IOException e) {
            e.printStackTrace(); // @TODO: is there a better way to handle this exception?
        }
    }

    public static Request getLastRequest() {
        if (requestStack.empty()) {
            return null;
        }
        return requestStack.pop();
    }

    public synchronized static void requestExecuted(Request r) {
        if (requestStack.size() > maxStackSize) {
            // @TODO: check out if this matters for performance vs single .remove calls
            int removeElements = maxStackSize - preferredStackSize;
            List<Request> removeFromStack = new ArrayList<>(removeElements);
            for (int i = 0; i < removeElements; i++) {
                // add the bottom-most items from the stack to the removeAll collection
                removeFromStack.add(requestStack.get((requestStack.size() - 1) - i));
            }
            requestStack.removeAll(removeFromStack);
        }

        requestStack.push(r);
    }

    public abstract void execute() throws IOException, InterruptedException;


}
