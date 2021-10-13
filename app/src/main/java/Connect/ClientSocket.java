package Connect;

import java.io.IOException;
import java.net.Socket;

public class ClientSocket {

    Socket socket;

    public ClientSocket(String ip,int port){
        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
