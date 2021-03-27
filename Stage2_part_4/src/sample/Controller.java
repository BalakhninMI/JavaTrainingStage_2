package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    @FXML
    public TextArea taMain;
    @FXML
    public TextField tfMessage;
    @FXML
    public Button btnSend;



    public void btnOnMouseClicked(MouseEvent mouseEvent) {
        Date date = new Date();
        if (tfMessage.getLength()>0){
            taMain.appendText(new SimpleDateFormat("d-M-y H:m:s").format(date) + " "+tfMessage.getText() + "\n");
            tfMessage.clear();
        }
    }

    public void onEnter(ActionEvent actionEvent) {
        Date date = new Date();
        if (tfMessage.getLength()>0){
            taMain.appendText(new SimpleDateFormat("d-M-y H:m:s").format(date) + " "+tfMessage.getText() + "\n");
            tfMessage.clear();
        }
    }
}
