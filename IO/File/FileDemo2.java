import java.io.File;
/**
 * 
 * @author lxz35
 *�����̷�������·��
 */
public class FileDemo2 {
	public static void main(String[] args) {
		String patString ="C:/Users/lxz35/eclipse-workspace/IO/src/ÿ����ϰ.jpeg";
		//juedui
		File strFile=new File(patString);
		System.out.println(strFile.getAbsolutePath());
		//xiangdui
		System.out.println();System.getProperty("user.dir");
		strFile = new File("ÿ����ϰ.jpeg");
		System.out.println(strFile.getAbsolutePath());
		
	}

}
