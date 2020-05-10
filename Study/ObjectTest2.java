import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import javax.tools.JavaCompiler;

/*
 * 对象流
 * 写出后读取
 * 读取的顺序和写出的保持一致
 * object output stream
 * object input stream
 * 
 * 不是所有的对象都可以序列化，serializable
 */
public class ObjectTest2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//写出 序列化
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream dataOutputStream = new ObjectOutputStream(new BufferedOutputStream(byteArrayOutputStream));
		//操作数据类型+数据
		dataOutputStream.writeUTF("lxy");
		dataOutputStream.write(18);
		dataOutputStream.writeChar('a');
		//对象
		dataOutputStream.writeObject("llxxyy");
		dataOutputStream.writeObject(new Date());
		Employee employee= new Employee(22,11);
		dataOutputStream.writeObject(employee);
		dataOutputStream.flush();
		byte[] datas = byteArrayOutputStream.toByteArray();
	
		//读取反序列化
		ObjectInputStream dataInputStream = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//顺序一致
		String msgString = dataInputStream.readUTF();
		int age = dataInputStream.readInt();
		//
		//
		
		System.out.println(msgString);
		//对象的数据还原
		Object strObject = dataInputStream.readObject();
		Object emplObject = dataInputStream.readObject();
		
		if (strObject instanceof String) {
	        strObject =(String)strObject;
	        System.out.println(strObject);
		}
		if (strObject instanceof Employee) {
	        emplObject =(String)emplObject;
	        System.out.println(emplObject);
		}
	}

}
//javeben
class Employee implements Serializable{
	private transient double income;//该数据不序列化
	
	int age;
	public Employee(double income, int age) {
		super();
		this.income = income;
		this.age = age;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
