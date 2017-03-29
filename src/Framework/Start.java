package Framework;

import Framework.Dialogs.UserNameDialog;

import java.io.IOException;

/**
 * Created by peterzen on 2017-03-27.
 * Part of the framework project.
 */
public class Start {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World from Framework.Start");
        System.out.println(Config.get("game", "turnTimeout"));
    }

}
