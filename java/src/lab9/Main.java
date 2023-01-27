package lab9;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Monitor monitor = new Monitor();
        Random random = new Random();
        Sensor sensor1 = new Sensor(1, random.nextInt(3), monitor);
        Sensor sensor2 = new Sensor(2, random.nextInt(3), monitor);
        Sensor sensor3 = new Sensor(3, random.nextInt(3), monitor);
        Sensor sensor4 = new Sensor(4, random.nextInt(3), monitor);

        Dispatcher dispatcher = new Dispatcher("dispatcher", monitor);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(dispatcher);
        executorService.submit(sensor1);
        executorService.submit(sensor2);
        executorService.submit(sensor3);
        executorService.submit(sensor4);
    }
}
