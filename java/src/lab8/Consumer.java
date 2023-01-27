package lab8;

public class Consumer extends Thread{
	private String name;
	private Shared sh;
	
	public Consumer(String name, Shared sh) {
		super();
		this.name = name;
		this.sh = sh;
	}

	@Override
	public void run() {
		while(true){
			Integer i = sh.remove();
			System.out.println(i+" was removed by "+name);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
