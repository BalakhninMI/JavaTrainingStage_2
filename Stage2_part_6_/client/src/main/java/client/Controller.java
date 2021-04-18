package client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public TextArea taMain;
    @FXML
    public TextField tfMessage;

    private static Socket socket;
    private static DataInputStream in;
    private static DataOutputStream out;
    private final int PORT = 8190;
    private final String IP_ADDRESS = "localhost";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(()->{
            tfMessage.requestFocus();
        });
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(()->{
                try{
                    while (true){
                        String str = in.readUTF();

                        taMain.appendText(str + "\n");
                        if (str.equals("/end")){
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg() {
        try {
            out.writeUTF(tfMessage.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        tfMessage.clear();
        tfMessage.requestFocus();
//        Date date = new Date();
//        if (tfMessage.getLength()>0){
//            taMain.appendText(new SimpleDateFormat("("+"d-M-y H:m:s").format(date) + ") "+tfMessage.getText() + "\n");
//            tfMessage.clear();
//        }
    }
}
