package lab9;

import java.util.Date;
import java.util.Random;

public class Sensor implements Runnable {

    private int id;
    private Monitor monitor;
    private int type;


    public Sensor(int id, int type, Monitor monitor) {
        this.id = id;
        this.monitor = monitor;
        this.type = type;
    }

    @Override
    public void run() {
        while (true) {
            monitor.add(new SensorEvent(id, type, new Date()));
            try {
                Random rand = new Random();
                Thread.sleep(rand.nextInt(5) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
