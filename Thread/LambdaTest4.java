package com.lxy;
/**
 * lambda推导  加入参数返回值
 * @author lxz35
 *
 */

public class LambdaTest4 {
	public static void main(String[] args) {
		new Thread(()-> System.out.println("一边学习")).start();
		new Thread(()-> System.out.println("一边哭")).start();
}
}




