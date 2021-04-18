package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

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
                        String str = in.readUTF();
                        if (str.equals("/end")){
                            out.writeUTF("/end");
                            break;
                        }
                        out.writeUTF("Echo: " + str);
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
}
