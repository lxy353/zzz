import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class loginMutilServer4 {
	public static void main(String[] args) throws IOException {
		System.out.println("server");
		ServerSocket socket = new ServerSocket(9999);
		boolean isRuning = true;
		while (isRuning) {
			Socket clientSocket = socket.accept();
			System.out.println("一个客户建立了连接");
			new Thread(new Channel(clientSocket)).start();
		}
		socket.close();
	}
}
class Channel implements Runnable{
	private Socket client;
	//输入流
	private DataInputStream dis;
	//输出流
	private DataOutputStream dos ;
	public Channel(Socket clientSocket) {
		this.client=clientSocket;
		try {
			dis= new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			release();
		}	
	}
	//接受数据
	private String receive() {
		String daString="";
		try {
			daString = dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daString;
		
	}
	//释放资源
	private void release() {
		try {
			if (null!=dos) {
				dos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (null!=dis) {
				dis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {if (null!=client) {
			client.close();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//发送数据
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		String username="";
		String password="";
		String[] dataStrings = receive().split("&");
		for (String info:dataStrings) {
			String[] userinfor = info.split("=");
			
			if (userinfor[0].equals("username")) {
				System.out.println("user:"+userinfor[1]);
				username = userinfor[1];
			}else if (userinfor[0].equals("password")) {
				System.out.println("password:"+userinfor[1]);
				password = userinfor[1];
			} 		
			
		}
		
		
		if (username.equals("lxy")&&password.equals("lxy990130")) {
			send("登录成功");
		}else {
			send("用户名或密码错误");
		}
		release();
		
	}

}
