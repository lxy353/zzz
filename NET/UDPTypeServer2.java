import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * 接收端
 * 1.使用datagramSocket  指定端口 创建接受端
 * 2.准备容器 封装datagrampacket
 * 3阻塞接受包裹 recieve（datagrampacket p）
 * 4.分析数据 把字节数组还原成为对应的类型
 * get data 
 * get length
 * 5.释放资源
 */
public class UDPTypeServer2 {
	public static void main(String[] args) throws Exception {
		System.out.println("接受方启动中");
//		 * 1.使用datagramSocket  指定端口 创建接受端
		DatagramSocket datagramSocket = new DatagramSocket(9999);
//		 * 2.准备容器 封装datagrampacket
		byte[] container = new byte[1024];
		DatagramPacket packet = new DatagramPacket(container, 0,container.length);
//		 * 3阻塞接受包裹 recieve（datagrampacket p）
		datagramSocket.receive(packet);
//		 * 4.分析数据 把字节数组还原成为对应的类型
//		 * get data 
//		 * get length
		byte[] datas = packet.getData();
		int len= packet .getLength();
		DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//顺序一致
		String msgString = dataInputStream.readUTF();
		int age = dataInputStream.readInt();
		System.out.println(msgString);
		System.out.println(age);
//		 * 5.释放资源
		datagramSocket.close();
		
	}

}
