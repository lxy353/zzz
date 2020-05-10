import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
public class ObjectTest3 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//写出 序列化
		
		ObjectOutputStream dataOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.txt")));
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
		dataOutputStream.close();
		
	
		//读取反序列化
		ObjectInputStream dataInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")));
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
		dataInputStream.close();
	}

}
//javeben

	
