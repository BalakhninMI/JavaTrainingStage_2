package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import java.util.Scanner;

public class Client {
    private static Socket socket;
    private static DataInputStream in;
    private static DataOutputStream out;
    private final int PORT = 8190;
    private final String IP_ADDRESS = "localhost";

    public Client() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

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
        System.out.println("server: "+str);
    }
}
