package com.lxy;
/**
 * lambda推导  加入参数返回值
 * @author lxz35
 *
 */

public class LambdaTest3 {
	public static void main(String[] args) {
		IHate hate =(int a1,int a2)-> {
			// TODO Auto-generated method stub
			System.out.println("i like lambda" + (a1+a2));
			return a1+a2;
		};
		hate.lambda(100, 200);
		
		 hate = (a1, a2)-> {
			// TODO Auto-generated method stub
			System.out.println("i like lambda" + (a1+a2));
			return a1+a2;
		};
		hate.lambda(10, 20);
		System.out.println(hate.lambda(100, 299));
		
}
interface IHate{
		int lambda(int a,int b);
	}
//外部类
class Hate implements IHate{
	@Override
	public int lambda(int a1,int a2) {
		// TODO Auto-generated method stub
		System.out.println("i like lambda" + (a1+a2));
		return a1+a2;
		
	}
	
}
}


