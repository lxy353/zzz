import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * 接收端
 * 1.使用datagramSocket  指定端口 创建接受端
 * 2.准备容器 封装datagrampacket
 * 3阻塞接受包裹 recieve（datagrampacket p）
 * 4.分析数据
 * get data 
 * get length
 * 5.释放资源
 */
public class UDPServer {
	public static void main(String[] args) throws Exception {
		System.out.println("接受方启动中");
//		 * 1.使用datagramSocket  指定端口 创建接受端
		DatagramSocket datagramSocket = new DatagramSocket(889);
//		 * 2.准备容器 封装datagrampacket
		byte[] container = new byte[1024];
		DatagramPacket packet = new DatagramPacket(container, 0,container.length);
//		 * 3阻塞接受包裹 recieve（datagrampacket p）
		datagramSocket.receive(packet);
//		 * 4.分析数据
//		 * get data 
//		 * get length
		byte[] datas = packet.getData();
		int len= packet .getLength();
		System.out.println(new String(datas,0,len));
//		 * 5.释放资源
		datagramSocket.close();
		
	}

}
