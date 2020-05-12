import java.awt.List;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.print.attribute.Size2DSyntax;
import javax.sound.midi.Sequence;

/**��װ
 * �����ȡ��д���� random access file
 * @author lxz35
 *
 */
public class SplitFile2 {
	//Դͷ
	private File srFile;
	//Ŀ�ĵأ��ʼۼУ�
	private String destDirString;
	//���зָ����ļ��洢·��
	private ArrayList<String> destPaths;
	//ÿ���С
	private int blockSize ;
	//���ٿ�
	private int size;
	
	public SplitFile2(String srFile, String destDirString, int blockSize) {
		// TODO Auto-generated constructor stub
		this.srFile= new File(srFile);
		this.destDirString=destDirString;
		this.blockSize=blockSize;
		this.destPaths = new ArrayList<String>();
		//��ʼ��
		init();
	}
	
	private void init() {
		// �ܳ���
		long len = this.srFile.length();
		//���ٿ�
		this.size = (int)Math.ceil(len*1.0/blockSize);
		//lujing
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDirString+"i"+"-"+this.srFile.getName());
			
		}
		
	}
	/**
	 * �ָ�
	 * ����ÿһ�������λ�úʹ�С
	 * �ָ�
	 * @throws IOException 
	 */
	public void split() throws IOException {
	
		// �ܳ���
		long len = srFile.length();
		
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
			
			splitDetail(i, begin, actualsize);
		
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
	public  void splitDetail(int i,int began,int actaualsize) throws IOException {

		RandomAccessFile radAccessFile= new RandomAccessFile(this.srFile, "r");
		RandomAccessFile radAccessFile2= new RandomAccessFile(this.destPaths.get(i), "rw");

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
		radAccessFile.close();
	
	}
	//�ļ��ĺϲ�
	public void merge(String destPath) throws IOException {
		//�����
		OutputStream oStream = new BufferedOutputStream(new FileOutputStream(destPath,true));
		Vector<InputStream>vInputStreams  =new Vector<InputStream>();
		SequenceInputStream siSequenceInputStream= null;
		//������
		for (int i = 0; i < destPaths.size(); i++) {
			vInputStreams.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
		}
		siSequenceInputStream = new SequenceInputStream(vInputStreams.elements());
			//copy
			byte[]flush = new byte[1024];
			int len = -1;
			while ((len = siSequenceInputStream.read(flush))!=-1) {
				oStream.write(flush, 0, len);
			}
			oStream.flush();
			siSequenceInputStream.close();
		oStream.close();
		
	}
	public static void main(String[] args) throws IOException {
		SplitFile2 splitFile = new SplitFile2("C:/Users/lxz35/eclipse-workspace/IO-3/src/100 (1).jpg","dest",1024*10);
		splitFile.split();
	}
	}

