/*
 * Inetaddress
 * 两个成员方法
 * 1.gethostaddress:返回地址
 * 2.gethoustname:返回主人名字
 */
import java.net.InetAddress;

import java.net.UnknownHostException;


public class IPTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
		
		address = InetAddress.getByAddress("www.google.com", null);
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
		
		address = InetAddress.getByAddress("123.56.128.176", null);
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
	}

}
