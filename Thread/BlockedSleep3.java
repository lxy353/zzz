package com.lxy;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * sleepģ����Ϣ
 * @author lxz35
 *
 */

 class BlockedSleep3  {
	 
	 public static void main(String[] args) throws InterruptedException {
		 //������
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
		 //����10������1s һ��
		  int num =10;
		  while (true) {
			  Thread.sleep(1000);
			  System.out.println(num--);
			
		}
		
	}
 
 }
