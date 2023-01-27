package lab10;

public class InternationalFlight extends Flight{
    private String arrivalCountry;

    public InternationalFlight(long id, String departure, String arrival, int time, String arrivalCountry) {
        super(id, departure, arrival, time);
        this.arrivalCountry = arrivalCountry;
    }

    @Override
    public long computeCost() {
        return 7*this.getTime();
    }
}
