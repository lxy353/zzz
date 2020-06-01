package com.lxy;
/**
 * lambda推导  加入参数
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
//外部类
class Love implements Ilove{
	@Override
	public void lambda(int a) {
		// TODO Auto-generated method stub
		System.out.println("i like lambda" + a);
		
	}
	
}



