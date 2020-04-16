

import java.util.Random;
/**
 *  根据交通信号灯颜色决定汽车停车、行驶和慢行
 * @author lxy
 *
 */
public class Q3 {
	public static void main(String[] args) {
       
        // switch语句中使用枚举
        int a = new Random().nextInt(3); // 生成0，1，2，的随机数
        switch (Light.values()[a]) {
        case YELLOW:
            System.out.println("黄灯慢行");
            break;
        case GREEN:
            System.out.println("绿灯行驶");
            break;
        case RED:
            System.out.println("红灯停车");
            break;
        }
    }
}
/**交通信号灯颜色*/
enum Light {
	YELLOW, GREEN, RED
}

