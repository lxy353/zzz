package com.lxy;
/**
 * lambda�Ƶ�  �������
 * @author lxz35
 *
 */

public class LambdaTest2 {
	
	
	

	public static void main(String[] args) {
		Ilove love=(int a)->{
			System.out.println("i like lambda" + a);
		};
		love.lambda(100);
		
	}
}
interface Ilove{
		void lambda(int a);
	}
//�ⲿ��
class Love implements Ilove{
	@Override
	public void lambda(int a) {
		// TODO Auto-generated method stub
		System.out.println("i like lambda" + a);
		
	}
	
}



