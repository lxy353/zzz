import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 打印流 print write
 * @author lxz35
 *
 */
public class PrintTest2 {
	public static void main(String[] args) throws FileNotFoundException {
		//打印流system.out
		PrintWriter pStream = new PrintWriter(new BufferedOutputStream(new FileOutputStream("print.txt")));
		pStream.println("aa");
		pStream.println(true);
		pStream.close();
	}

}
