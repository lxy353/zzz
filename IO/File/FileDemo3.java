import java.io.File;

public class FileDemo3 {
	public static void main(String[] args) {
		File srDemo3 = new File("C:\\Users\\lxz35\\eclipse-workspace\\IO\\src\\36 (1).jpg");
		//basic information
		System.out.println("name"+srDemo3.getName());
		System.out.println("lujing"+srDemo3.getPath());
		System.out.println(""+srDemo3.getAbsolutePath());
		System.out.println(srDemo3.getParent());
		System.out.println(srDemo3.getParentFile());
	}

}
