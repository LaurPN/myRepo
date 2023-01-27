package lab1_hw;

public class Person {
    private String surname;
    private String name;
    private String CNP;

    public Person(String surname, String name, String CNP) {
        this.surname = surname;
        this.name = name;
        this.CNP = CNP;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", CNP='" + CNP + '\'' +
                '}';
    }
}
