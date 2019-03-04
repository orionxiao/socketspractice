import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("Waiting for client");

        Socket socket = serverSocket.accept();

        System.out.println("Client connected");

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        byte buffer[] = new byte[1024];
        in.read(buffer);

        System.out.println("Received from client - " + new String(buffer).trim());

        out.write("Hello from the server".getBytes());

        socket.close();
        serverSocket.close();
    }
}
