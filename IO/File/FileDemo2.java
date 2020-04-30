import java.io.File;
/**
 * 
 * @author lxz35
 *存在盘符，绝对路径
 */
public class FileDemo2 {
	public static void main(String[] args) {
		String patString ="C:/Users/lxz35/eclipse-workspace/IO/src/每日练习.jpeg";
		//juedui
		File strFile=new File(patString);
		System.out.println(strFile.getAbsolutePath());
		//xiangdui
		System.out.println();System.getProperty("user.dir");
		strFile = new File("每日练习.jpeg");
		System.out.println(strFile.getAbsolutePath());
		
	}

}
