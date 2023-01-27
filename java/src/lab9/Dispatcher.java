package lab9;

public class Dispatcher implements Runnable{

    private String name;
    private Monitor monitor;

    public Dispatcher(String name, Monitor monitor) {
        this.name = name;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            SensorEvent event = monitor.remove();
            System.out.println("Event: " + event.getSensorId() + ", " + " type: " + event.getType() + ", " + event.getTime().toString());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
