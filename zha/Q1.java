
import java.util.Scanner;

/**
 * 验证键盘输入的用户名不能为空，长度大于6，不能有数字。
 * @author xxyh
 *
 */
public class Q1 {
	public static void main(String[] args) {
		System.out.println("请输入用户名(不能为空，长度大于6，不能有数字)：");
		Scanner scanner =new Scanner(System.in);
		String str = scanner.nextLine();
		//判断是否含有数字 (正则表达式)
		String regex = ".*[0-9].*";  
		boolean result = str.matches(regex);
		if(str.equals("")){
			System.out.println("用户名不能为空！");
		}else if(str.length()<7){
			System.out.println("用户名长度必须大于6");
		}else if(result){
			System.out.println("用户名不能有数字");
		}else{
			System.out.println("用户名为："+str);
		}
	}
}
