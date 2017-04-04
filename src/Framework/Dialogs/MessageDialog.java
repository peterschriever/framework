package Framework.Dialogs;

import javafx.scene.control.Alert;

/**
 * Class MessageDialog
 *
 * @author Ruben Buisman
 * @version 0.1 (03-04-2017)
 */
public class MessageDialog implements DialogInterface {

    private final String messageTitle;
    private final String messageHeader;
    private final String messageContent;

    public MessageDialog(String messageTitle, String messageHeader, String messageContent) {
        this.messageTitle = messageTitle;
        this.messageHeader = messageHeader;
        this.messageContent = messageContent;
    }

    /**
     * @param messageTitle   Sets the title for the message dialog.
     * @param messageHeader  Sets the header of the dialog.
     * @param messageContent Sets the content of the dialog.
     */
    public void display() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(messageTitle);
        alert.setHeaderText(messageHeader);
        alert.setContentText(messageContent);
        alert.showAndWait();
    }
}
