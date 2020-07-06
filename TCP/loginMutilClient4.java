import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class loginMutilClient4 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("client");
		//建立连接
		Socket clientSocket = new Socket("localhost",9999);
		//操作：输入输出流操作 先请求后响应
		new Send(clientSocket).send();
		new Receive(clientSocket).receive();
		clientSocket.close();
	}
//发送	
static class Send{
	private Socket clientSocket;
	private DataOutputStream dataOutputStream;
	private BufferedReader bufferedReader ;
	private String msg;
	public Send(Socket clientSocket) {
		 bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		 this.msg = init();
		 this.clientSocket=clientSocket;
		 try {
		dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		 } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 }	
	}
	private String init() {
		try {
			System.out.println("请输入用户名");
			String username = bufferedReader.readLine();
			System.out.println("请输密码");
			String password = bufferedReader.readLine();
			return "username="+username+"&"+"password="+password;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
		
	}
	public void send() {
		try {
			dataOutputStream.writeUTF(msg);
			dataOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
//接受
	static class Receive{
		private DataInputStream dis;
		private Socket clientSocket;
		public Receive(Socket clientSocket){
			this.clientSocket=clientSocket;
			try {
				dis= new DataInputStream(clientSocket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	public void  receive() {
		String daString;
		try {
			daString = dis.readUTF();
			System.out.println(daString);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}	
		}	
	}
}
