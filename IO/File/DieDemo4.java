import java.io.File;
import java.util.Iterator;
/**
 * �ݹ飬�Լ������Լ�
 * ��ӡ����Ŀ¼���ļ�����
 * 
 * @author lxz35
 *
 */
public class DieDemo4 {
	public static void main(String[] args) {
		File srcFile = new File("C:\\Users\\lxz35\\eclipse-workspace\\IO\\src");
		printname(srcFile, 0);
	
			}
	//��ӡ����Ŀ¼
	public static void printname(File srcFile,int deep) {
		//����ǰ��Ĳ�θ�
		for (int i = 0; i < deep; i++) {
			System.out.println("-");
		}
		System.out.println(srcFile.getName());//��ӡ����
		if (null==srcFile|| !srcFile.exists()) {//�ݹ�ͷ
			System.out.println("file exist");
		}else {
			if(srcFile.isDirectory()) {//Ŀ¼
				for(File s:srcFile.listFiles()) {
					printname(s, deep+1);//�ݹ���
				}
				
			}
		}
	}
		
	}
			
		
		


