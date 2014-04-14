package main;

public class ListenThread extends Thread {
	Messager messager;
	public ListenThread(Messager target){
		messager = target;
	}
	public void run(){
		while(true){
			messager.receiveMsg();
		}
	}
}
