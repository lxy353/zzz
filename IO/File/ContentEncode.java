import java.io.UnsupportedEncodingException;

/**
 * ±àÂë£º×Ö·û´® ×Ö½Ú
 * @author lxz35
 *
 */
public class ContentEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String mString=" ĞÔÃüĞÔÃüÊ¹Ãü";
		byte[] datas= mString.getBytes();
		System.out.println(datas.length);
		
		datas=mString.getBytes("UTF-16LE");
		System.out.println(datas.length);
		
	}

}
