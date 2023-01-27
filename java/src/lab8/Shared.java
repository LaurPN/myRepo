package lab8;

import java.util.LinkedList;
import java.util.Queue;

public class Shared {
	private Queue<Integer> queue = new LinkedList<>();
	public static final int MAX_SIZE = 5;
	public synchronized void add(Integer a){
		while(queue.size() > MAX_SIZE)
			try {
				System.out.println("Blocked add");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		queue.add(a);
		notify();		
	}
	
	public synchronized Integer remove(){
		while(queue.isEmpty())
			try {
				System.out.println("Blocked remove");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		notify();
		return queue.remove();				
	}
}
