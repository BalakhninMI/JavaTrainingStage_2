package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private final int PORT = 8190;

    public ClientHandler(Server server, Socket socket) {

        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            this.server = server;
            this.socket = socket;

            new Thread(()->{
                try{
                    while (true){
                        getMsg(in.readUTF());
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

            new Thread(()->{
                try{
                    Scanner strScan = new Scanner(System.in);
                    while (true){
                        try {
                            out.writeUTF(strScan.nextLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
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

    void getMsg(String str){
        System.out.println("client: "+str);
    }

//    public void sendMsg(String str) {
//        try {
//            out.writeUTF(tfMessage.getText());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        tfMessage.clear();
//        tfMessage.requestFocus();
////        Date date = new Date();
////        if (tfMessage.getLength()>0){
////            taMain.appendText(new SimpleDateFormat("("+"d-M-y H:m:s").format(date) + ") "+tfMessage.getText() + "\n");
////            tfMessage.clear();
////        }
//    }
}
