import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/*
 * 多次交流发送端
 *  1.使用datagramSocket  指定端口 创建接受端
 * 2.准备数据，一定要转成字节数组 
 * 3封装包裹 datagrampacket，需要指定位置
 * 4.发送包裹send datagrampacket
 * 5.释放资源
 */
public class UDPClient5 {
	public static void main(String[] args) throws IOException {
		System.out.println("发送方启动中。。。。。。");
//		  1.使用datagramSocket  指定端口 创建接受端
		DatagramSocket clientSocket = new DatagramSocket(8888);
//		 * 2.准备数据，一定要转成字节数组 
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			
		
		String dataString = reader.readLine();
		byte[] datas = dataString.getBytes();
//		 * 3封装包裹 datagrampacket，需要指定位置
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,new InetSocketAddress("localhost",9999));
//		 * 4.发送包裹send datagrampacket
		clientSocket.send(packet);
		if (datas.equals("bye")) {
			break;
			
		}
		}
//		 * 5.释放资源
		clientSocket.close();
//		
	}

}
