import java.io.File;

public class FileDemo4 {
	public static void main(String[] args) {
		File srDemo4 = new File("C:\\Users\\lxz35\\eclipse-workspace\\IO\\src\\36 (1).jpg");
		System.out.println(srDemo4.getAbsolutePath());
		System.out.println(srDemo4.exists());
		System.out.println(srDemo4.isDirectory());
		System.out.println(srDemo4.isFile());
		
		 srDemo4 = new File("36 (1).jpg");
		System.out.println(srDemo4.getAbsolutePath());
		System.out.println(srDemo4.exists());
		System.out.println(srDemo4.isDirectory());
		System.out.println(srDemo4.isFile());
		
		
		srDemo4 = new File("xxx");
		if (null==srDemo4|| !srDemo4.exists()) {
			System.out.println("file exist");
		}else {
			if(srDemo4.isFile()) {
				System.out.println("file");
			}else {
				System.out.println("dir");
			}
		}
	}

}
