package lab9;

import lab8_part2.Pizza;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
    private Queue<SensorEvent> sensorEventQueue;
    final Lock lock=new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    public Monitor() {
        this.sensorEventQueue = new LinkedList<>();
    }

    public static final int MAX_SIZE = 10;

    public void add(SensorEvent a) {
        lock.lock();
        while (sensorEventQueue.size() > MAX_SIZE) {
            try {
                System.out.println("Blocked add");
                notFull.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }}
        sensorEventQueue.add(a);
        notEmpty.signal();
        lock.unlock();

    }
    public SensorEvent remove() {
        lock.lock();
        while(sensorEventQueue.isEmpty())
            try {
                System.out.println("Blocked remove");
                notEmpty.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        notFull.signal();
        lock.unlock();
        return sensorEventQueue.remove();
    }

    public Queue<SensorEvent> getQueue() {
        return sensorEventQueue;
    }
}
