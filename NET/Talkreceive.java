import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * ���ܶˣ�ʹ����������װ
 */
public class Talkreceive implements Runnable{
	private DatagramSocket server;
	public  Talkreceive(int port) {
		try {
			server = new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			byte[] container = new byte[1024];
			DatagramPacket packet = new DatagramPacket(container, 0,container.length);
//			 * 3�������ܰ��� recieve��datagrampacket p��
			try {
				server.receive(packet);
				byte[] datas = packet.getData();//			 * 4.��������
//				 * get data 
//				 * get length
				int len= packet .getLength();
				System.out.println(new String(datas,0,len));
				if (datas.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			 * 5.�ͷ���Դ
			server.close();
			}
		
	}

}
