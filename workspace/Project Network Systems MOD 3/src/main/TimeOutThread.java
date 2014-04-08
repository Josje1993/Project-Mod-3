package main;

public class TimeOutThread extends Thread {
	Messager messager;

	public TimeOutThread(Messager target) {
		messager = target;
	}

	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		messager.close();
	}
}
