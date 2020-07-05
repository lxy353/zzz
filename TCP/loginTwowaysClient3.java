import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;



public class loginTwowaysClient3 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("client");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名");
		String username = bufferedReader.readLine();
		System.out.println("请输密码");
		String password = bufferedReader.readLine();
		Socket clientSocket = new Socket("localhost",9999);
		DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());		
		dataOutputStream.writeUTF("username:"+username+"&"+"password:"+password);
		dataOutputStream.flush();
		
		DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
		String daString = dis.readUTF();
		System.out.println(daString);
		dataOutputStream.close();
		dis.close();
	}

}
