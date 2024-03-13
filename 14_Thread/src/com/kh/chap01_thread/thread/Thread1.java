package com.kh.chap01_thread.thread;



	
//	스레드 생성방법 1.
//	Thread 클래스를 상속받는 방법.
//	
//	-Thread클래스 상속 후 run() 메서드 오버라이딩
//	-main에 thread1객체 생성 후 start() 메서드 호출
//	start()호출시 해당 스레드 내부의 run메서드가 실행된다.
//	즉, 스레드를 새롭게 가동시키려면 start()를 실행해야 하고, 해당 스레드의 작업방식은 run메서드 내부에 기술헤야 한다.
	

	
	
	
	public class Thread1 extends Thread{
	
	
	@Override
	public void run() { 	// 실행하고자 하는 코드를 작성
		
		for(int i = 1; i <=10; i++) {
			System.out.println(getName() + "["+i+"]");
			// getName() : 스레드의 이름반환(스레드 이름 미지정시 Thread-0, Thread-1 .. 순으로 자동부여)
		}
	}
	
	
	
	
	
	
	
	
	
	
}
