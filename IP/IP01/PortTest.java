import java.net.InetSocketAddress;
/**
 * 端口
 * 1.区分软件
 * 2. 2个字节 0-65525 UDP TCP
 * 3.同一个协议端口不可以冲突
 * 4.定义端口越大越好
 * 1.构造器
 * new insocketaddress
 * 2.方法
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
