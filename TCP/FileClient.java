import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class FileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("client");
		Socket clientSocket = new Socket("localhost",9999);
		InputStream is = new BufferedInputStream(new FileInputStream(""));
		OutputStream os = new BufferedOutputStream(clientSocket.getOutputStream());
		
		dataOutputStream.writeUTF(dataString);
		dataOutputStream.flush();
		dataOutputStream.close();
	}

}
