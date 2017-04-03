package Framework.Dialogs;

import javafx.geometry.Insets;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;

/**
 * Created by Ruben on 03-Apr-17.
 */
abstract public class AbstractDialog {

    public Dialog dialog;
    public GridPane grid;

    public void display(){}

    public void createDialog(String dialogTitle, String dialogHeader){
        dialog = new Dialog();
        dialog.setTitle(dialogTitle);
        dialog.setHeaderText(dialogHeader);
    }

    public void createGrid(){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 10, 10, 10));
    }


}
