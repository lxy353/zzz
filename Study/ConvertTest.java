import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder.Redirect;

/**
 * 转换流：inputstreamreader outputstreamwriter
 * @author lxz35
 *1.以字符流的形式操作字节流 纯文本
 *2.指点字符集
 */
public class ConvertTest {
	public static void main(String[] args) {
		try(BufferedReader reader=new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(System.out));){
			//循环获取键盘的输入（） 输出
			String msgString ="";
			while (!msgString.equals("exit")) {
			msgString = reader.readLine();//循坏读取
			writer.write(msgString);//循坏写出
			writer.newLine();
			writer.flush();//强制刷新
		}
		}catch (IOException e) {
			System.out.println("操作异常");
				
			}
	
	}

}

