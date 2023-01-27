package lab6;

public class Person {
    private String name;
    private String gender;
    private String jobDescription;
    private int experience;
    private String location;

    public Person(String name, String gender, String jobDescription, int experience, String location) {
        this.name = name;
        this.gender = gender;
        this.jobDescription = jobDescription;
        this.experience = experience;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", experience=" + experience +
                ", location='" + location + '\'' +
                '}';
    }
}
