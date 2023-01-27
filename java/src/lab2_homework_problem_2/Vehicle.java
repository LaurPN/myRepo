package lab2_homework_problem_2;

public abstract class Vehicle implements Taxable, Comparable<Vehicle> {
    private double basePrice;
    private String name;
    private String country;

    public Vehicle(double basePrice, String name, String country) {
        this.basePrice = basePrice;
        this.name = name;
        this.country = country;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "basePrice=" + basePrice +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public int compareTo(Vehicle o) {
        if (this.computeTotalTax() > o.computeTotalTax()){
            return 1;
        } else if (this.computeTotalTax() < o.computeTotalTax()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
