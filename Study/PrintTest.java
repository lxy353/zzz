import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * ��ӡ�� print stream
 * @author lxz35
 *
 */
public class PrintTest {
	public static void main(String[] args) throws FileNotFoundException {
		//��ӡ��system.out
		PrintStream pStream = System.out;
		pStream.println("aa");
		pStream.println(true);
		
		pStream = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")));
		pStream.println("aa");
		pStream.println(true);
		pStream.close();
		
		
		//�ض��������
		System.setOut(pStream);
		System.out.println("change");
		//�ض����
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("change");
	}

}
