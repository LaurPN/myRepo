package lab1_hw;

public class Loan {
    private int id;
    private double amount;
    private Person person;

    public Loan(int id, double amount, Person person) {
        this.id = id;
        this.amount = amount;
        this.person = person;
    }

    public void increaseAmount(double added){
        this.amount += added;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", amount=" + amount +
                ", person=" + person +
                '}';
    }


}
