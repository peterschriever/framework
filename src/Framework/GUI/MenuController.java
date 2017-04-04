package Framework.GUI;

import Framework.Dialogs.AbstractDialog;
import Framework.Dialogs.ConnectionDialog;
import Framework.Dialogs.DialogInterface;
import Framework.Dialogs.MessageDialog;
import Framework.Start;
import Framework.TempTTTGame.TTTGameStart;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

/**
 * Created by femkeh on 03/04/17.
 */
public class MenuController {
    @FXML private MenuItem newTTT;

    public void newTTTGame(ActionEvent actionEvent) {
        System.out.println("TTTGameStart new TicTacToe game...");

        // @TODO: change TTTGame package to use the actual Tic-tac-toe.jar classes
        TTTGameStart tttGame = new TTTGameStart(Start.getInstance().getStage(), Start.getInstance().getScene());
        tttGame.start();
        Start.getInstance().setRunningGame(tttGame);
    }

    public void newOthGame(ActionEvent actionEvent) {
        System.out.println("TTTGameStart new Othello game...");
    }

    public void pause(ActionEvent actionEvent) {
        System.out.println("Game paused");
    }

    public void endGame(ActionEvent actionEvent) {
        System.out.println("Game ended");
    }

    public void showHighScores(ActionEvent actionEvent) {
        System.out.println("High scores");
    }

    public void giveHint(ActionEvent actionEvent) {
        DialogInterface testDialog = new ConnectionDialog();
        testDialog.display();
    }

    public void undoMove(ActionEvent actionEvent) {
        System.out.println("Undo move");
    }

    public void saveGame(ActionEvent actionEvent) {
        System.out.println("Saving game...");
    }

    public void quit(ActionEvent actionEvent) {
        System.out.println("Quit game");
        Platform.exit();
    }

}
