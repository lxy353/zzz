/*
 * 实现放大器对声音放大的功能
 */
public class DecorateTest {
	public static void main(String[] args) {
		Person p = new Person();
		p.say();
		Amplifier amplifier = new Amplifier(p);
		amplifier.say();
	}

}
interface Say{
	void say();
}


class Person implements Say{
	private int voice = 10;
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("voic:"+this.getVoice());
		
	}
	public int getVoice() {
		return voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	}
	
	
}
class Amplifier implements Say{
	private Person p;
	public Amplifier(Person p) {
		this.p=p;
		// TODO Auto-generated constructor stub
	}
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("voic"+p.getVoice()*100);
		System.out.println("zaoyin");
	}
}