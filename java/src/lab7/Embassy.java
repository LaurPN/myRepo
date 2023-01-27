package lab7;

// package lab7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Embassy {
    public Queue<VisaRequest> visaRequestQueue = new LinkedList<>();
    private int limit;

    public Embassy(int limit) {
        this.limit = limit;
    }

    public synchronized void submit(VisaRequest request) {
        while (visaRequestQueue.size() == limit) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        visaRequestQueue.add(request);
    }

    public synchronized VisaRequest process() {
        while (visaRequestQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        return visaRequestQueue.remove();

    }
}
