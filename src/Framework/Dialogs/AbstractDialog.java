package Framework.Dialogs;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;

/**
 * Class AbstractDialog
 *
 * @author Ruben Buisman
 * @version 0.1 (03-04-2017)
 */
abstract public class AbstractDialog {

    protected DialogEvents eventHandler;
    public Dialog dialog;
    public GridPane grid;

    public abstract void display();

    public AbstractDialog(DialogEvents eventHandler) {
        this.eventHandler = eventHandler;
    }

    public void createDialog(String dialogTitle, String dialogHeader){
        dialog = new Dialog();
        dialog.setTitle(dialogTitle);
        dialog.setHeaderText(dialogHeader);
        dialog.initStyle(StageStyle.UTILITY);
    }

    public void createGrid(){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 10, 10, 10));
    }

    public void createButtons(String buttonText, TextField textField) {
        ButtonType button = new ButtonType(buttonText, ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(button, ButtonType.CANCEL);

        // Enable/Disable connect button depending on whether a ip was entered.
        Node connectButton = dialog.getDialogPane().lookupButton(button);
        connectButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            connectButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);
    }

}
