import java.io.File;
import java.util.Iterator;
/**

 * ͳ���ļ��ӵĴ�С
 * @author lxz35
 *
 */
public class DieDemo3 {
	public static void main(String[] args) {
		File srcFile = new File("C:\\Users\\lxz35\\eclipse-workspace\\IO\\src");
		Count(srcFile);
	    System.out.println("len"+len);
			}
	private static long len=0;
	public static void Count(File srcFile) {
		//��ȡ��С
		if (null!=srcFile&&srcFile.exists()) {
			if (srcFile.isFile()) {//��С
				len+=srcFile.length();
				
			}else {//���Ｐ
				for (File s:srcFile.listFiles()) {
					Count(s);
					
				}
			}
			
		}
	}
		
	}
			
		
		


