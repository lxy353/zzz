import java.net.InetSocketAddress;
/**
 * �˿�
 * 1.�������
 * 2. 2���ֽ� 0-65525 UDP TCP
 * 3.ͬһ��Э��˿ڲ����Գ�ͻ
 * 4.����˿�Խ��Խ��
 * 1.������
 * new insocketaddress
 * 2.����
 * get address
 * getport
 * gethostname
 * @author lxz35
 *
 */

public class PortTest {
	public static void main(String[] args) {
		InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
		InetSocketAddress socketAddress2 = new InetSocketAddress("localhost",9000);
		System.out.println(socketAddress.getHostName());
		System.out.println(socketAddress2.getHostName());
		System.out.println(socketAddress.getPort());
	}

}
