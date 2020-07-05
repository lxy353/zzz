import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;



public class loginClient2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("client");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名");
		String username = bufferedReader.readLine();
		System.out.println("请输密码");
		String password = bufferedReader.readLine();
		Socket clientSocket = new Socket("localhost",9999);
		DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		
		String dataString = "lxy";
		dataOutputStream.writeUTF("username:"+username+"&"+"password"+password);
		dataOutputStream.flush();
		dataOutputStream.close();
	}

}
