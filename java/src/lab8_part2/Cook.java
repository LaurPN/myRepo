package lab8_part2;

import java.util.Objects;
import java.util.Random;

public class Cook extends Thread{
    private Kitchen kitchen;

    public Cook(Kitchen kitchen) {
        super();
        this.kitchen = kitchen;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            Pizza aux = new Pizza(r.nextInt(3,7));
            kitchen.add(aux);
            System.out.println("pizza number " + aux.getId() + "was added");
            try {
                sleep(5 + aux.getNumberOfIngredients()*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
