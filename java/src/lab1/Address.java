package lab1;

public class Address {
    private String city;
    private int number;
    private String street;

    public Address(String city, int number, String street) {
        this.city = city;
        this.number = number;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", number=" + number +
                ", street='" + street + '\'' +
                '}';
    }
}
