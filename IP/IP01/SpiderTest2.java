import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络爬虫原理
 * @author lxz35
 *
 */
public class SpiderTest2 {
	public static void main(String[] args) throws IOException {
		//获取url
		//URL url  = new URL("https://www.jd.com");
		//URL url  = new URL("https://www.dianping.com");
		//下载
		InputStream iStream = url.openStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(iStream,"UTF-8"));
		String msgString= null;
		while (null!=(msgString=bufferedReader.readLine())) {
			System.out.println(msgString);
			
		}
		bufferedReader.close();
		//分析
		//整理
	}

}
