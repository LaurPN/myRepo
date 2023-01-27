package lab8_part2;

public class Waiter extends Thread{
    private Kitchen kitchen;

    public Waiter(Kitchen kitchen) {
        super();
        this.kitchen = kitchen;
    }

    @Override
    public void run() {
        while (true) {
            Pizza pizza = kitchen.remove();
            System.out.println("Pizza " + pizza.getId() + " was removed");
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
