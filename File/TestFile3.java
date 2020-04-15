import java.io.File;
public class TestFile3 {
    public static void main(String[] args) throws Exception {
        File f = new File("d:/c.txt");
        f.createNewFile(); // 会在d盘下面生成c.txt文件
        f.delete(); // 将该文件或目录从硬盘上删除
        File f2 = new File("d:/电影/华语/大陆");
        boolean flag = f2.mkdir(); //目录结构中有一个不存在，则不会创建整个目录树
        System.out.println(flag);//创建失败
    }
}