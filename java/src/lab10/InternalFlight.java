package lab10;

public class InternalFlight extends Flight {
    public InternalFlight(long id, String departure, String arrival, int time) {
        super(id, departure, arrival, time);
    }

    @Override
    public long computeCost() {
        return 3*this.getTime();
    }
}
