package lab10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FlightOperator> flightOperators = new ArrayList<>();
        List<Flight> flights = new ArrayList<>();
        Airport otp = new Airport(flightOperators, flights);
        Frame1 frame1 = new Frame1(otp);
        frame1.setVisible(true);
    }
}
