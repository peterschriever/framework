package Framework.GUI;

import Framework.Start;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;

/**
 * Created by femkeh on 03/04/17.
 */
public class MenuController {
    @FXML private MenuItem newTTT;

    public void newTTTGame(ActionEvent actionEvent) {
        System.out.println("Start new TicTacToe game...");
    }

    public void newOthGame(ActionEvent actionEvent) {
        System.out.println("Start new Othello game...");
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
        System.out.println("Possible next move");
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
