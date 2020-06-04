package com.lxy;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * sleep模拟休息
 * @author lxz35
 *
 */

 class BlockedSleep3  {
	 
	 public static void main(String[] args) throws InterruptedException {
		 //倒计数
		 Date enDate = new Date(System.currentTimeMillis()+1000*10);
		 long end = enDate.getTime();
		 while (true) {
			 System.out.println(new SimpleDateFormat("mm:ss").format(enDate));
			 Thread.sleep(1000);
			 enDate = new Date(enDate.getTime()-1000);
			 if (end-10000>enDate.getTime()-1000) {
				break;
			}
			
		}
			
		}
		
	

	 
	 public static void test() throws InterruptedException {
		 //倒数10个数，1s 一个
		  int num =10;
		  while (true) {
			  Thread.sleep(1000);
			  System.out.println(num--);
			
		}
		
	}
 
 }
