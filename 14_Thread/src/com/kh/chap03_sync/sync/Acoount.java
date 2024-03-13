package com.kh.chap03_sync.sync;

// 계좌
// 2개의 Atm기에서 동시 접속할 예정

public class Acoount {

	
	private int balance = 10000;
	
	
	public int getBalance() {
		return balance;
	}
	
	public  void withdraw(int money) {
		
//		synchronized(격리공간)
//		:: 동기화 메서드, 동기화 블럭에 사용되는 키워드
//		동기화 메서드는 메서드 선언에 synchronized키워드를 붙이고, 인스턴스 및 정적메서드에서도 사용이 가능함.
//		동기화 메서드는 스레드가 메서드를 실행하면 메서드 전체에 즉시 락을 걸고 메서드 종료시 락이 풀린다.
//		메서드 전체가 아니라 일부 내용에만 락을 걸고 싶다면 동기화 블럭을 이용하면 됨.
//		락이 걸려 있다면 락을 해소할 수 있는 키를 가진 스레드만 접근이 가능해진다.
		
		
		synchronized(this) {
		
		String threadName = Thread.currentThread().getName();
		System.out.println("현재 계좌에 남아있는 잔액? : " + balance);
		
		if (money <= balance) {
			balance -= money;
			System.out.printf("[%s] %d원 출금 >> 잔액 : %d원%n", threadName, money, balance);
		} else {
			System.out.printf("[%s] %d원 출금시도 >> 현재 잔액 : %d%n", threadName, money, balance);
		}
	}
	}
	
//		동기화란 ?
//		:: 멀티스레드 프로그램에서 스레드간의 공유자원에 대한 처리
//		공유자원의 사용순서를 정해서 한 번에 한 개의 스레드만 공유자원에 접근하여 사용할 수 있도록 제어함.
		
		
	
	
	
	
	
	
	
	
	
	

}
