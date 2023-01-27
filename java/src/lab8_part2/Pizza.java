package lab8_part2;

import java.util.concurrent.atomic.AtomicInteger;

public class Pizza {
    private int id;
    private int numberOfIngredients;
    static AtomicInteger count = new AtomicInteger(0);

    public Pizza(int numberOfIngredients) {
        this.id = count.incrementAndGet();
        this.numberOfIngredients = numberOfIngredients;
    }

    public int getId() {
        return id;
    }


    public int getNumberOfIngredients() {
        return numberOfIngredients;
    }

}
