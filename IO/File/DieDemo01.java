import java.io.File;

public class DieDemo01 {
	public static void main(String[] args) {
		File dirFile = new File("C:\\Users\\lxz35\\eclipse-workspace\\dir");
		boolean flag = dirFile.mkdirs();
		System.out.println(flag);
		
	 dirFile = new File("C:\\Users\\lxz35\\eclipse-workspace\\dir2");
		 flag = dirFile.mkdir();
		System.out.println(flag);
		
	}

}
