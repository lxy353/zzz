import java.io.UnsupportedEncodingException;

/**
 * 解码：字符串  字节
 * @author lxz35
 *
 */
public class ContentDecode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String mString=" 性命性命使命";
		byte[] datas= mString.getBytes();
		System.out.println(datas.length);
		
		datas=mString.getBytes("UTF-16LE");
		System.out.println(datas.length);
		//解码
		mString=new String(datas,0,datas.length,"GBK");
		System.out.println(mString);
	}

}
