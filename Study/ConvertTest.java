import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder.Redirect;

/**
 * ת������inputstreamreader outputstreamwriter
 * @author lxz35
 *1.���ַ�������ʽ�����ֽ��� ���ı�
 *2.ָ���ַ���
 */
public class ConvertTest {
	public static void main(String[] args) {
		try(BufferedReader reader=new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(System.out));){
			//ѭ����ȡ���̵����루�� ���
			String msgString ="";
			while (!msgString.equals("exit")) {
			msgString = reader.readLine();//ѭ����ȡ
			writer.write(msgString);//ѭ��д��
			writer.newLine();
			writer.flush();//ǿ��ˢ��
		}
		}catch (IOException e) {
			System.out.println("�����쳣");
				
			}
	
	}

}

