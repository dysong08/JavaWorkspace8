package com.kh.chap02_scheduling.run;

import com.kh.chap02_scheduling.scheduling.*;

public class SchejuleRun {

	public static void main(String[] args) {

		Thread th1 = new Thread(new Car(), "Car");
		Thread th2 = new Thread(new Tank(), "Tank");
		Thread th3 = new Thread(new Plane(), "Plane");
		
//		우선순위 변경전
//		각 스레드는 기본값으로 5의 우선순위를 가지고 있다.
//		메모리가 모자랄때 우선순위를 파악해서 어떤 작업을 먼저 실행시킬지 정할 수 있다.
//		스레드의 우선순위를 정하지 않으면 스케쥴러가 임의로 수행시킨다.
		
//		스레드는 cpu를 할당받았다가 스케쥴러에 의해 다시 선점당한다.
//		=> 명령어의 실행이 연속적이지 못하고 어느 부분까지 수행했는지 기억할 필요가 있다.
		
		System.out.println("====우선순위 변경 전 ====");
		System.out.println(Thread.currentThread().getName()+ "의 우선순위 : " + Thread.currentThread().getPriority());
		System.out.println(th1.getName() + "의 우선순위" + th1.getPriority());
		System.out.println(th2.getName() + "의 우선순위" + th2.getPriority());
		System.out.println(th3.getName() + "의 우선순위" + th3.getPriority());
		
//		setPriority() : 우선순위를 지정해주는 메서드
		th1.setPriority(Thread.MAX_PRIORITY);	// 10
		th2.setPriority(Thread.MIN_PRIORITY);	// 1
		//th3.setPriority(Thread.NORM_PRIORITY);	// 5
		
		System.out.println("====우선순위 변경 후 ====");
		System.out.println(Thread.currentThread().getName()+ "의 우선순위 : " + Thread.currentThread().getPriority());
		System.out.println(th1.getName() + "의 우선순위" + th1.getPriority());
		System.out.println(th2.getName() + "의 우선순위" + th2.getPriority());
		System.out.println(th3.getName() + "의 우선순위" + th3.getPriority());
		
//		메인 스레드가 종료되더라도 실행 중인 스레드가 하나라도 있으면 프로세스는 종료되지 않는다.
//		이에 대한 해결책으로 스레드를 생성(start()) 하기전에 스레드간의 주종관계를 설정하면 된다.
//		
//		주종관계 설정
//		main스레드가 종료시 다른 스레드도 종료시키기 위해서는 setDaemon()함수를 사용.
//		
//		주의점 : 스레드중 한개라도 setDaemon을 설정했다면 모든 스레드에 setDaemon설정을 해야 정상작동 한다.
		
		
		th1.setDaemon(true);
		th2.setDaemon(true);
		th3.setDaemon(true);
		
		th1.start();
		th2.start();
		th3.start();
		
		System.out.println("메인스레드 종료");
		
		
		
	}

}
