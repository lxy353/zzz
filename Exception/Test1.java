public class Test1 {
    public static void main(String[] args) {
        int a=0;
        int b = 1;
        if(a!=0) {
        System.out.println(b/a);
    }
        String str=null;
        if (str!=null) {
        	 System.out.println(str.length());
		}
        Animal e=new Dog();
        if (e instanceof Cat) {
            Cat c = (Cat) e;
        }
       
    }
}
    class Animal{
        
    }
    class Dog extends Animal{
         
    }
    class Cat extends Animal{
         
    }
    
           
    
