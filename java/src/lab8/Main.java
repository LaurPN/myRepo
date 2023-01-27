package lab8;

public class Main {

	public static void main(String[] args) {
		Shared sh = new Shared();
		Consumer c1=new Consumer("c1",sh); c1.start();
		Consumer c2=new Consumer("c2",sh); c2.start();
		Consumer c3=new Consumer("c3",sh); c3.start();
		Consumer c4=new Consumer("c4",sh); c4.start();
		Consumer c5=new Consumer("c5",sh); c5.start();
		Producer p1 = new Producer("p1",sh); p1.start();
		Producer p2 = new Producer("p2",sh); p2.start();
		Producer p3 = new Producer("p3",sh); p3.start();
		
		
	}

}
