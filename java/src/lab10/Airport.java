package lab10;

import java.util.List;

public class Airport
{
    private List<FlightOperator> flightOperators;
    private List<Flight> flights;

    public Airport(List<FlightOperator> flightOperators, List<Flight> flights) {
        this.flightOperators = flightOperators;
        this.flights = flights;
    }

    public List<FlightOperator> getFlightOperators() {
        return flightOperators;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public void setFlightOperators(List<FlightOperator> flightOperators) {
        this.flightOperators = flightOperators;
    }
}
