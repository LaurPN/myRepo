package lab8_part2;

public class Main {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        Cook c1 = new Cook(kitchen); c1.start();
        Cook c2 = new Cook(kitchen); c2.start();
        Cook c3 = new Cook(kitchen); c3.start();

        Waiter w1 = new Waiter(kitchen); w1.start();
        Waiter w2 = new Waiter(kitchen); w2.start();
        Waiter w3 = new Waiter(kitchen); w3.start();
        Waiter w4 = new Waiter(kitchen); w4.start();
    }
}
