import java.io.UnsupportedEncodingException;

/**
 * ���룺�ַ��� �ֽ�
 * @author lxz35
 *
 */
public class ContentEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String mString=" ��������ʹ��";
		byte[] datas= mString.getBytes();
		System.out.println(datas.length);
		
		datas=mString.getBytes("UTF-16LE");
		System.out.println(datas.length);
		
	}

}
