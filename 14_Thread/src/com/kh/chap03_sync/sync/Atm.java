package com.kh.chap03_sync.sync;

public class Atm implements Runnable {

	private Acoount acc;

	public Atm() {

	}

	public Atm(Acoount acc) {
		this.acc = acc;
	}

	@Override
	public void run() {

		while (acc.getBalance() > 0) {
			// 100~500원 출금

			int money = (int) (Math.random() * 5 + 1) * 100;

			acc.withdraw(money);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println(Thread.currentThread().getName() + "종료");
	}

}
