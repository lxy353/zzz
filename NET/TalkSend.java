import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/*
 * 发送段
 */
public class TalkSend implements Runnable {
	private DatagramSocket datagramSocket;
	private BufferedReader reader;
	public TalkSend (int port) {
		try {
			datagramSocket = new DatagramSocket(9999);
		    reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {	
			
		
		String dataString = null;
		try {
			dataString = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] datas = dataString.getBytes();
//		 * 3封装包裹 datagrampacket，需要指定位置
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,new InetSocketAddress("localhost",9999));
//		 * 4.发送包裹send datagrampacket
		try {
			datagramSocket.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (datas.equals("bye")) {
			break;
			
		}
		}
		
		
	}
	public static void main(String[] args) {
		
	}

}
