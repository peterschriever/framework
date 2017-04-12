package Framework.Dialogs;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
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
    public ButtonType buttonType = ButtonType.OK;
    public ButtonType buttonType2 = ButtonType.CANCEL;

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

    public void createButtons() {
        dialog.getDialogPane().getButtonTypes().addAll(buttonType, buttonType2);
        dialog.getDialogPane().setContent(grid);
    }

    public void buttonClickCheck() {
        Button button = (Button) dialog.getDialogPane().lookupButton(buttonType);
        button.addEventFilter(ActionEvent.ACTION, event ->
                executeCallback()
        );
    }

    public abstract void executeCallback();
}
