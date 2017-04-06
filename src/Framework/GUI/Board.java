package Framework.GUI;

import javafx.fxml.FXML;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * Created by femkeh on 03/04/17.
 */
public class Board {
    @FXML protected GridPane gridPane;

    public void drawGrid(int boardSize) {
        int i;
        for (i = 0; i < boardSize; i++) {
            ColumnConstraints column = new ColumnConstraints(gridPane.getPrefWidth()/boardSize);
            RowConstraints row = new RowConstraints(gridPane.getPrefHeight()/boardSize);
            gridPane.getColumnConstraints().add(column);
            gridPane.getRowConstraints().add(row);
        }
    }
}
