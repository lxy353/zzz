import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 熟悉流程
 * 创建服务器
 * 
 * 指定端口 使用serversocket 创建服务器
 * 阻塞等待连接accept
 * 操作输入输出流操作
 * 释放资源
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("server");
		ServerSocket socket = new ServerSocket(9999);
		Socket clientSocket = socket.accept();
		System.out.println("一个人创建了连接");
		DataInputStream dataOutputStream = new DataInputStream(clientSocket.getInputStream());
		String daString = dataOutputStream.readUTF();
		dataOutputStream.close();
		
		socket.close();
		
		
	}

}
