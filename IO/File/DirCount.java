import java.io.File;

public class DirCount {
	//大小
	private  long len;
	//问价夹
	private String pathString;
	//文件的个数
	private int file_number;
	//文件夹个数
	private int dir_size;
	//源
	private File src;
	public DirCount(String pathString) {
		super();
		this.pathString = pathString;
		this.src = new File(pathString);
		Count(this.src);
	
	}
	public  void Count(File srcFile) {
		//获取大小
		if (null!=srcFile&&srcFile.exists()) {
			if (srcFile.isFile()) {//大小
				len+=srcFile.length();
				this.file_number++;
				
			}else {//子孙及
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
