package lab7;

// package lab7;

public class Candidate extends Thread {
    String name;
    private int age;
    private int educationLevel;
    private Embassy embassy;

    public Candidate(String name, Embassy embassy, int age, int educationLevel) {
        super(name);
        this.name = name;
        this.embassy = embassy;
        this.age = age;
        this.educationLevel = educationLevel;
    }

    @Override
    public void run() {
        embassy.submit(new VisaRequest(this.name, this.age, this.educationLevel));
    }
}
