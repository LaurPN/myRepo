package lab7;

// package lab7;

import java.io.FileWriter;
import java.io.IOException;

public class Worker extends Thread {
    private String name;
    private Embassy embassy;

    public Worker(Embassy embassy) {
        this.embassy = embassy;
    }

    @Override
    public void run() {
        while (true) {
            VisaRequest visa = embassy.process();
            FileWriter writer;
            if (visa.getEducationLevel() > 3) {
                try {
                    writer = new FileWriter("visa" + visa.getName());
                    writer.write("Name: " + visa.getName() + "\n" +
                            "Age: " + visa.getAge() + "\n" + "Education Level: " + visa.getEducationLevel() + "\n");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    writer = new FileWriter("rejected_candidates", true);
                    writer.write("Name: " + visa.getName() + "\n" +
                            "Age: " + visa.getAge() + "\n" + "Education Level: " + visa.getEducationLevel() + "\n"
                            + "\n");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
