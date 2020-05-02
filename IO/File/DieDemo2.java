import java.io.File;
import java.util.Iterator;

public class DieDemo2 {
	public static void main(String[] args) {
		File dirFile = new File("C:\\Users\\lxz35\\eclipse-workspace\\dir");
		String[] subsNameStrings=dirFile.list();
		for (String string : subsNameStrings) {
			System.out.println(string);
			
			
			File[] suFiles = dirFile.listFiles();
			for(File e:suFiles) {
				System.out.println(e.getAbsolutePath());
				
				
				File[] rooFiles = dirFile.listRoots();
				for(File eFile : rooFiles) {
					System.out.println(e.getAbsolutePath());
				}
			}
			
		}
		
	}

}
