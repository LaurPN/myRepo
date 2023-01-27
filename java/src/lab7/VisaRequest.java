package lab7;

// package lab7;

public class VisaRequest {
    private String name;
    private int age;
    private int educationLevel;

    public VisaRequest(String name, int age, int educationLevel) {
        this.name = name;
        this.age = age;
        this.educationLevel = educationLevel;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getEducationLevel() {
        return educationLevel;
    }
}
