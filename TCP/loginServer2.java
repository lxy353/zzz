import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class loginServer2 {
	public static void main(String[] args) throws IOException {
		System.out.println("server");
		ServerSocket socket = new ServerSocket(9999);
		Socket clientSocket = socket.accept();
		System.out.println("一个客户建立了连接");
		DataInputStream dataOutputStream = new DataInputStream(clientSocket.getInputStream());
		String daString = dataOutputStream.readUTF();
		String[] dataStrings = daString.split("&");
		for (String info:dataStrings) {
			String[] userinfor = info.split("=");
			System.out.println(userinfor[0]+"---"+userinfor[0]);
			if (userinfor[0].equals("username")) {
				System.out.println("user:"+userinfor[1]);
				
			}else if (userinfor[0].equals("password")) {
				System.out.println("password:"+userinfor[1]);
				
			} 		
			
		}
		dataOutputStream.close();
		
		socket.close();
		
		
	}

}
