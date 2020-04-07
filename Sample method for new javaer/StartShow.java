import java.util.Scanner;

public class StartShow {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("艺人的名字是：");
        String name = scanner.nextLine();
        Star star = new Star();
        star.show(name);
    }
}

interface Film {  //电影接口
    void showFilm();
}
interface Teleplay {  //电视剧接口
    void showTeleplay();
}
interface Sing {   //歌手接口
    void showSing();
}

class Star implements Film,Teleplay,Sing {  //艺人类调用接口

    void show (String name) {
        System.out.println("大家好，我是" + name);
        showFilm();
        showTeleplay();
        showSing();
    }
    public void showFilm() {
        System.out.println("我能演电影！");
    }
    public void showTeleplay() {
        System.out.println("我能演电视剧!!");
    }
    public void showSing() {
        System.out.println("我还会唱歌！！！");
    }
}
