package com.lxy;
/**
 * lambda�Ƶ�
 * @author lxz35
 *
 */

public class LambdaTest {
	
	//��̬�ڲ���
	static class Like2 implements ILike{
		@Override
		public void lambda() {
			// TODO Auto-generated method stub
			System.out.println("i like lambda2");
		}
	}

	public static void main(String[] args) {
		
		ILike like = new Like();
		like.lambda();
		like = new Like2();
		like.lambda();
		class like3 implements ILike{
		public void lambda() {
			// TODO Auto-generated method stub
			System.out.println("i like lambda3");
		}
	}
		like = new like3();
		like.lambda();
		//�����ڲ���
		like = new ILike() {
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("i like lambda4");
			}
			
		};
		like.lambda();
		//lambda
		like =()->{
			System.out.println("i like lambda5");
		};
		like.lambda();
		
	}
}
interface ILike{
		void lambda();
	}
//�ⲿ��
class Like implements ILike{
	@Override
	public void lambda() {
		// TODO Auto-generated method stub
		System.out.println("i like lambda");
		
	}
	
}



