import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Date;

/*
 * �������ͷ��Ͷ�
 *  1.ʹ��datagramSocket  ָ���˿� �������ܶ�
 * 2.׼����������ת���ֽ����� 
 * 3��װ���� datagrampacket����Ҫָ��λ��
 * 4.���Ͱ���send datagrampacket
 * 5.�ͷ���Դ
 */
public class UDPFileClient4 {
	public static void main(String[] args) throws IOException {
		System.out.println("���ͷ������С�����������");
//		  1.ʹ��datagramSocket  ָ���˿� �������ܶ�
		DatagramSocket clientSocket = new DatagramSocket(8888);
//		 * 2.׼�����ݣ�һ��Ҫת���ֽ����� 
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream dataOutputStream = new ObjectOutputStream(new BufferedOutputStream(byteArrayOutputStream));
		//������������+����
		dataOutputStream.writeUTF("lxy");
		dataOutputStream.write(18);
		dataOutputStream.writeChar('a');
		//����
		dataOutputStream.writeObject("llxxyy");
		dataOutputStream.writeObject(new Date());
		Employee employee= new Employee(22,11);
		dataOutputStream.writeObject(employee);
		dataOutputStream.flush();
		byte[] datas = byteArrayOutputStream.toByteArray();
		System.out.println(datas.length);
	
//		 * 3��װ���� datagrampacket����Ҫָ��λ��
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,new InetSocketAddress("localhost",9999));
//		 * 4.���Ͱ���send datagrampacket
		clientSocket.send(packet);
//		 * 5.�ͷ���Դ
		clientSocket.close();
//		
	}

}
