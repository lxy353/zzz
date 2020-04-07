import java.util.Scanner;

public class test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("name：");
        String name = scanner.nextLine();
        System.out.println("----1=>Erhu---2=>Piano---3=>Violin----");
        System.out.print("what do you want to hear （1/2/3）：");
        int instrument = scanner.nextInt();
        if(instrument==1){
        	Instrument a = new Erhu();
        	new Musician(name,a);
           
        }
        else if(instrument==2) {
        	Instrument a = new Piano();
        	new Musician(name,a);
           
        }
        else if(instrument==3) {
        	Instrument a = new Violin();
        	new Musician(name,a);
           
        }else{
            System.out.println("dont play another");
        }
    }
}

abstract class Instrument { 
    abstract void makeSound();
}

class Erhu extends Instrument {  
    void makeSound() {
        System.out.println("Playing erhu！");
    }
}
class Piano extends Instrument {    
    void makeSound() {
        System.out.println("Playing piano！");
    }
}
class Violin extends Instrument {   
    void makeSound() {
        System.out.println("Playing Violin！");
    }
}
class Musician {    //乐手
    Musician(String name,Instrument i) {
        System.out.print(name);
        i.makeSound();
    }
}