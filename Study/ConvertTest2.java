import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder.Redirect;
import java.net.URL;

/**
 * ת������inputstreamreader outputstreamwriter
 * @author lxz35
 *1.���ַ�������ʽ�����ֽ��� ���ı�
 *2.ָ���ַ���
 */
public class ConvertTest2 {
	public static void main(String[] args) {
		try( BufferedReader iStream =new BufferedReader(new InputStreamReader( new URL("heep://www.baidu.com").openStream()));){
			//ѭ����ȡ���̵����루�� ���
		String msgString;
			while ((msgString = iStream.readLine())!=null) {
				System.out.println(msgString);
			
		}
		}catch (IOException e) {
			System.out.println("�����쳣");
				
			}
		
	
	}
	private void test1() {
		try( InputStreamReader iStream =new InputStreamReader( new URL("heep://www.baidu.com").openStream());){
			//ѭ����ȡ���̵����루�� ���
		int temp ;
			while ((temp=iStream.read())!=-1) {
				System.out.println((char)temp);
			
		}
		}catch (IOException e) {
			System.out.println("�����쳣");
				
			}
		
	}
	private void test() {
		try( InputStream iStream =new URL("heep://www.baidu.com").openStream();){
			//ѭ����ȡ���̵����루�� ���
		int temp ;
			while ((temp=iStream.read())!=-1) {
				System.out.println((char)temp);
			
		}
		}catch (IOException e) {
			System.out.println("�����쳣");
				
			}
		
	}

}

