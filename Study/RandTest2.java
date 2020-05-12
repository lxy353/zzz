import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.print.attribute.Size2DSyntax;

/**
 * �����ȡ��д���� random access file
 * @author lxz35
 *
 */
public class RandTest2 {
	public static void main(String[] args) throws IOException {
		//�ֶ��ٿ�
		File sFile = new File("100(1).jpg");
		// �ܳ���
		long len = sFile.length();
		//ÿ���С
		int blockSize =1024;
		//���ٿ�
		int size = (int)Math.ceil(len*1.0/blockSize);
		int begin =0;
		int actualsize = (int) (blockSize>len?len:blockSize);
		for (int i = 0; i < size; i++) {
			begin=i*blockSize;
			if (i==size-1) {//���һ��
				actualsize=(int)len;
			}else {
				actualsize=blockSize;
						len-=actualsize;//ʣ����
			}
			System.out.println(i+"---"+begin + "----"+actualsize);
			split(i, begin, actualsize);
			
		}
			
	}
	//ָ����ʼλ�ã���ȡʣ������
	
	
	

	/**
	 *  ָ����ʼλ�ú�ʵ�ʳ���
	 * @param i
	 * @param began
	 * @param actaualsize
	 * @throws IOException
	 */
	public static void split(int i,int began,int actaualsize) throws IOException {

		RandomAccessFile radAccessFile= new RandomAccessFile(new File("100(1).jpg"), "r");
		RandomAccessFile radAccessFile2= new RandomAccessFile(new File("dest/"+i+"100(1).jpg"), "rw");

		radAccessFile.seek(2);
		byte[] flush  = new byte[1024];// ��������
		//����
		int len = -1;
		while ((len=radAccessFile.read(flush))!=-1) {
			//decode
			if (actaualsize>len) {
				System.out.println(new String(flush,0,len));
				radAccessFile2.write(flush,0,len);
				actaualsize-=len;
			}
			else {
				radAccessFile2.write(flush,0,actaualsize);
				break;
			}
			
		}
		radAccessFile2.close();
	
	}
		
	}

