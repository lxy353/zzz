import java.io.File;

public class DirCount {
	//��С
	private  long len;
	//�ʼۼ�
	private String pathString;
	//�ļ��ĸ���
	private int file_number;
	//�ļ��и���
	private int dir_size;
	//Դ
	private File src;
	public DirCount(String pathString) {
		super();
		this.pathString = pathString;
		this.src = new File(pathString);
		Count(this.src);
	
	}
	public  void Count(File srcFile) {
		//��ȡ��С
		if (null!=srcFile&&srcFile.exists()) {
			if (srcFile.isFile()) {//��С
				len+=srcFile.length();
				this.file_number++;
				
			}else {//���Ｐ
				this.dir_size++;
				for (File s:srcFile.listFiles()) {
					Count(s);
					
				}
			}
			
		}
	}
	public int getDir_size() {
		return dir_size;
	}	

	public int getFile_number() {
		return file_number;
	}

	public  long getLen() {
		return len;
	}
	
	
	public void setLen(long len) {
		this.len = len;
	}
	public static void main(String[] args) {
		DirCount dirCount = new DirCount("C:\\Users\\lxz35\\eclipse-workspace\\IO\\src");
		System.out.println(dirCount.getLen()+"wnejianzha"+dirCount.getDir_size() +"wenjan"+dirCount.getFile_number());
	}

}
