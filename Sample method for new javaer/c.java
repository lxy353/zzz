import java.util.Scanner;
/**
 * @author Linger
 * 计算圆面积、周长‘圆柱体的体积。
 */

public class c {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("radius：");
        double radius = scanner.nextDouble();

        System.out.print("high：");
        double hight = scanner.nextDouble();

        Circle cylinder = new Cylinder(radius,hight);
        cylinder.show();
        Cylinder circle = (Cylinder)cylinder;  //convert to son
        circle.showVolume();    //use son
    }
}

class Circle {
    private double radius;  //radius

    Circle(){
    }

    Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {     //Area
        return Math.PI * Math.pow(radius,2.0);
    }

    double getPerimeter() {    //Perimeter
        return 2 * Math.PI * radius;
    }

    void show() {   
        System.out.println("Radius：" + radius);
        System.out.println("Radius：" + radius + "Perimeter：" + getPerimeter());
        System.out.println("Radius：" + radius + "Area：" + getArea());
    }
}

class Cylinder extends Circle {
    private double hight; 

    Cylinder(double radius, double hight) {
        super(radius);
        this.hight = hight;
    }

    double getVolume() { 
        return getArea() * hight;
    }

    void showVolume() {     
        System.out.println("H：" + hight);
        System.out.println("V：" + getVolume());
    }
}
