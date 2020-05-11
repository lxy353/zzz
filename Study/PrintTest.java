import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 打印流 print stream
 * @author lxz35
 *
 */
public class PrintTest {
	public static void main(String[] args) throws FileNotFoundException {
		//打印流system.out
		PrintStream pStream = System.out;
		pStream.println("aa");
		pStream.println(true);
		
		pStream = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")));
		pStream.println("aa");
		pStream.println(true);
		pStream.close();
		
		
		//重定向输出端
		System.setOut(pStream);
		System.out.println("change");
		//重定向回
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("change");
	}

}
