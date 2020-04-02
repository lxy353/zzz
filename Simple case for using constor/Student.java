
public class Student {

	 //属性（成员变量）
    int id;
    String sname;
    int age;  
    Computer comp;// computer
    
    //方法
    void study(){
        System.out.println("Studying"+comp.brand);
    } 
    void play() {
    	System.out.println("Gaming"+comp.brand);
    }
    //构造方法，用于创建这个对象，无参的方法可以有系统自己创建
    Student(){
    	
    }
   public static void main(String[] args) {
	   Student student = new Student();//create 对象
	   student.id=23731161;
	   student.sname="Xingyu";
	   student.age=20;
	   
	   Computer c1 = new Computer();
	   c1.brand="dell";
	   student.comp=c1;
	   student.play();
	   student.study();
	   
   }
}

class Computer{
	String brand;
}