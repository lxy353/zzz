import java.io.File;
import java.util.Iterator;
/**

 * 统计文件加的大小
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
		//获取大小
		if (null!=srcFile&&srcFile.exists()) {
			if (srcFile.isFile()) {//大小
				len+=srcFile.length();
				
			}else {//子孙及
				for (File s:srcFile.listFiles()) {
					Count(s);
					
				}
			}
			
		}
	}
		
	}
			
		
		


