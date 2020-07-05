import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	public static void main(String[] args) throws IOException {
		System.out.println("server");
		ServerSocket socket = new ServerSocket(9999);
		Socket clientSocket = socket.accept();
		InputStream is = new BufferedInputStream(new FileInputStream(""));
		OutputStream os = new BufferedOutputStream(clientSocket.getOutputStream());
        clientSocket.close();
		socket.close();
		
		
	}

}
