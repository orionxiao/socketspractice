import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        Socket socket = serverSocket.accept();

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        byte buffer[] = new byte[1024];
        in.read(buffer);

        System.out.println("Received from client - " + new String(buffer).trim());

        out.write("Hello from Server...".getBytes());

        socket.close();
        serverSocket.close();
    }
}
