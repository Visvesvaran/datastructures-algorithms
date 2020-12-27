package com.beginnerlevel.threading;

public class ThreadMain {

	public static void main(String[] args) {
		for (int i = 0; i < 8; i++) {
			FirstThreadExtendsThread t1 = new FirstThreadExtendsThread();
			t1.start();
		}
		
		for (int i = 0; i < 8; i++) {
			Thread t2 = new Thread(new SecondThreadImplementsRunnable());
			t2.start();
		}
		
		for (int i = 0; i < 8; i++) {
			Runnable r1 = new Runnable() {
				
				@Override
				public void run() {
					System.out.println ("ThirdThreadRunnableAnonymous " + 
			                  Thread.currentThread().getId() + 
			                  " is running");
				}
			};
			
			Thread t3 = new Thread(r1);
			t3.start();
			
		}
		
		for (int i = 0; i < 8; i++) {
			Runnable r8 = () -> System.out.println ("FouthThreadRunnableUsingLambda " + 
			                  Thread.currentThread().getId() + 
			                  " is running");
			
			Thread t4 = new Thread(() -> System.out.println ("FouthThreadRunnableUsingLambda " + 
	                  Thread.currentThread().getId() + 
	                  " is running"));
			t4.start();
			
		}
	}

}
