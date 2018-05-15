package com.sergio;

public class Main {

	public static void main(String[] args) {
		Countdown countdown1 = new Countdown();
		
		CountdownThread t1 = new CountdownThread(countdown1);
		t1.setName("Thread 1");
		CountdownThread t2 = new CountdownThread(countdown1);
		t2.setName("Thread 2");
		
		t1.start();
		t2.start();
	}
}

class Countdown{
	
	private int i;
	
	public synchronized void doCountdown() {

		synchronized(this) {
		for(i=10;i>0;i--) {
			System.out.println(Thread.currentThread().getName() + ": i = " + i);
			}
		}
	}
}

class CountdownThread extends Thread{
	private Countdown threadCountdown;

	public CountdownThread(Countdown threadCountdown) {
		this.threadCountdown = threadCountdown;
	}
	
	public void run() {
		threadCountdown.doCountdown();
	}
	
}