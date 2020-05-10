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
 * ������
 * д�����ȡ
 * ��ȡ��˳���д���ı���һ��
 * object output stream
 * object input stream
 * 
 * �������еĶ��󶼿������л���serializable
 */
public class ObjectTest3 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//д�� ���л�
		
		ObjectOutputStream dataOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.txt")));
		//������������+����
		dataOutputStream.writeUTF("lxy");
		dataOutputStream.write(18);
		dataOutputStream.writeChar('a');
		//����
		dataOutputStream.writeObject("llxxyy");
		dataOutputStream.writeObject(new Date());
		Employee employee= new Employee(22,11);
		dataOutputStream.writeObject(employee);
		dataOutputStream.flush();
		dataOutputStream.close();
		
	
		//��ȡ�����л�
		ObjectInputStream dataInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")));
		//˳��һ��
		String msgString = dataInputStream.readUTF();
		int age = dataInputStream.readInt();
		//
		//
		
		System.out.println(msgString);
		//��������ݻ�ԭ
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

	
