import java.net.MalformedURLException;
import java.net.URL;

/*
 * URL:ͳһ��Դ��λ���������������ʯͷ֮һ��html http�� ������Դ
 * 1.Э��
 * 2.�����������
 * 3.�˿ڣ������
 * 3.�˿�Ĭ��80
 * 4��������Դ
 * http://wwww.baidu.com80/index.html?uname = shsxt&age=18#a
 */
public class URLTest01 {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://wwww.baidu.com80/index.html?uname = shsxt&age=18#a");
		//��ȡ�ĸ�value
		System.out.println("Э�飺"+url.getProtocol());
		System.out.println("������ip��"+url.getHost());
		System.out.println("�˿ڣ�"+url.getPort());
		System.out.println("������Դ��"+url.getFile());
		System.out.println("������Դ��"+url.getPath());
		
		//����
		System.out.println("����"+url.getQuery());
		//ê��
		System.out.println("ê��"+url.getRef());
		
	}

}
