import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Test02 {
	public static void main(String[] args)  {
		FileReader reader = null;
		try {
			 reader = new FileReader("d:/a.test");
			
			char c = (char)reader.read();
			System.out.println("Step1");
		} catch (FileNotFoundException e) {
			System.out.println("Step2");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Step3");
			try {
				if(reader!=null) {
					reader.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
