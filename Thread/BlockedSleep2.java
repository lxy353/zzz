package com.lxy;
/**
 * sleepģ����Ϣ
 * @author lxz35
 *
 */

 class BlockedSleep2 implements Runnable {

		private static String winnerString;
		public void run() {
			// TODO Auto-generated method stub
			for(int steps =1; steps<=100; steps++) {
				//ģ����Ϣ
				if (Thread.currentThread().getName().equals("llx")&&steps%10==0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				System.out.println(Thread.currentThread().getName() +":"+steps);
				//�����Ƿ����
				boolean flag = gameOver(steps);
				if (flag) {
					break;
				}
				
			}
			
		}
		private boolean gameOver(int steps) {
			if (winnerString!= null) {
				return true;
			}
			else {
				if (steps== 100) {
					winnerString = Thread.currentThread().getName();
					System.out.println("winner:"+winnerString);
					
					
					return true;
					
				}
			}
			return false;
		}
		public static void main(String[] args) {
			Racer racer = new Racer();
			new Thread(racer,"lxy").start();
			new Thread(racer,"llx").start();
		}


	 
 }
