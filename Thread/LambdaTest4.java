package com.lxy;
/**
 * lambda�Ƶ�  �����������ֵ
 * @author lxz35
 *
 */

public class LambdaTest4 {
	public static void main(String[] args) {
		new Thread(()-> System.out.println("һ��ѧϰ")).start();
		new Thread(()-> System.out.println("һ�߿�")).start();
}
}




