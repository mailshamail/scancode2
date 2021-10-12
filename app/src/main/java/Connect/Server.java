package Connect;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server extends Thread {

    private ServerSocket serverSocket;

    public Server(int port, int time) throws IOException {
        serverSocket = new java.net.ServerSocket(port);
        serverSocket.setSoTimeout(time);
    }

    public void run() {

    }

    public static void Disconnect(){

    }

}
