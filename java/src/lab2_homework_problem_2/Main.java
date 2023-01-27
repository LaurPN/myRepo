package lab2_homework_problem_2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vehicle IVECO = new Truck(15000, "Iveco", "Romania");
        Vehicle MAN = new Bus(123123, "MAN", "Germany");
        Vehicle MERCEDES = new Minibus(3343433, "Mercedes Sprinter", "Spain");

        System.out.println(IVECO.toString() + "\n" + MAN.toString() + "\n" + MERCEDES.toString() + "\n" +
                IVECO.computeTotalTax() + "\n" + IVECO.computeRoadTax() + "\n" + IVECO.computeCustomTax()
                + "\n" + IVECO.computeVAT());
        Vehicle[] vehicles = {IVECO, MAN, MERCEDES};

        Arrays.sort(vehicles);
        for(int i = 0 ; i < vehicles.length; i++) {
            System.out.println(vehicles[i].toString());
        }
    }
}
