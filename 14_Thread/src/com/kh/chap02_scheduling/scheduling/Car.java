package com.kh.chap02_scheduling.scheduling;

public class Car implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());

		for(int i = 0; i <20; i++) {
			System.out.println("Car is drivind...");
			try {
				Thread.sleep(100);	// 스레드를 0.1초만큼 지연시키는 메서드
			} catch (InterruptedException e) {	// 충돌에러
				e.printStackTrace();
			}	
			
		}
	
	}

	
	
}
