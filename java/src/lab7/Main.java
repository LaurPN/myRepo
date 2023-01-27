package lab7;

// package lab7;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Embassy embassy = new Embassy(10);
        Random rand = new Random();
        ArrayList<Candidate> candidates = new ArrayList<>();
        ArrayList<Worker> workers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            candidates.add(new Candidate("Candidate" + i, embassy, rand.nextInt(90), rand.nextInt(10)));
        }
        for (int i = 1; i <= 5; i++) {
            workers.add(new Worker(embassy));
        }
        for (Candidate candidate : candidates) {
            candidate.start();
        }
        for (Worker worker : workers) {
            worker.start();
        }
    }
}
