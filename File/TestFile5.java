
import java.io.File;
import java.io.IOException;
public class TestFile5 {
    public static void main(String[] args) {
        //指定一个文件
        File file = new File("d:/sxt/b.txt");
        //判断该文件是否存在
        boolean flag= file.exists();
        //如果存在就删除，如果不存在就创建
        if(flag){
            //删除
            boolean flagd = file.delete();
            if(flagd){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }else{
            //创建
            boolean flagn = true;
            try {
                //如果目录不存在，先创建目录
                File dir = file.getParentFile();
                dir.mkdirs();
                //创建文件
                flagn = file.createNewFile();
                System.out.println("创建成功");
            } catch (IOException e) {
                System.out.println("创建失败");
                e.printStackTrace();
            }          
        }
        //文件重命名(同学可以自己测试一下)
        //file.renameTo(new File("d:/readme.txt"));
    }
}