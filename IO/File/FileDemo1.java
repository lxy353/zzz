import java.io.File;

public class FileDemo1 {
	public static void main(String[] args) {
		String patString ="C:/Users/lxz35/eclipse-workspace/IO/src/ÿ����ϰ.jpeg";
		
		// create file obj
		File srcDemo1 = new File(patString);
		System.out.println(srcDemo1.length());
		
		srcDemo1 = new File("C:/Users/lxz35/eclipse-workspace/IO/src","ÿ����ϰ.jpeg");
		System.out.println(srcDemo1.length());
		
		srcDemo1 = new File(new File("C:/Users/lxz35/eclipse-workspace/IO/src"),"ÿ����ϰ.jpeg");
		System.out.println(srcDemo1.length());
		
	}

}
