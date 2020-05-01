import java.io.File;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;

public class FileDemo6 {
	public static void main(String[] args) {
		File srcFile = new File("C:\\\\Users\\\\lxz35\\\\eclipse-workspace\\\\IO\\\\src\\\\36.txt");
		boolean flag = false;
		try {
			flag = srcFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(flag);
		srcFile = new File("C:\\\\Users\\\\lxz35\\\\eclipse-workspace\\\\IO\\\\src");
		flag = srcFile.delete();
		System.out.println(flag);
	}

}
