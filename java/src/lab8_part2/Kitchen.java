package lab8_part2;

import java.util.LinkedList;
import java.util.Queue;

public class Kitchen {
    private Queue<Pizza> queue;

    public Kitchen() {
        this.queue = new LinkedList<>();
    }

    public static final int MAX_SIZE = 10;
    public synchronized void add(Pizza a) {
        while (queue.size() > MAX_SIZE) {
            try {
                System.out.println("Blocked add");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
            queue.add(a);
            notify();

    }
    public synchronized Pizza remove() {
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

    public Queue<Pizza> getQueue() {
        return queue;
    }
}
