package lab10;

public abstract class Flight {
    private long id;
    private String departure;
    private String arrival;
    private int time;

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", time=" + time +
                '}';
    }

    public Flight(long id, String departure, String arrival, int time) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getTime() {
        return time;
    }

    public abstract long computeCost();
}
