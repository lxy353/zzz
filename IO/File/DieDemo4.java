import java.io.File;
import java.util.Iterator;
/**
 * 递归，自己调用自己
 * 打印子孙目录和文件名字
 * 
 * @author lxz35
 *
 */
public class DieDemo4 {
	public static void main(String[] args) {
		File srcFile = new File("C:\\Users\\lxz35\\eclipse-workspace\\IO\\src");
		printname(srcFile, 0);
	
			}
	//打印子孙目录
	public static void printname(File srcFile,int deep) {
		//控制前面的层次感
		for (int i = 0; i < deep; i++) {
			System.out.println("-");
		}
		System.out.println(srcFile.getName());//打印名字
		if (null==srcFile|| !srcFile.exists()) {//递归头
			System.out.println("file exist");
		}else {
			if(srcFile.isDirectory()) {//目录
				for(File s:srcFile.listFiles()) {
					printname(s, deep+1);//递归提
				}
				
			}
		}
	}
		
	}
			
		
		


