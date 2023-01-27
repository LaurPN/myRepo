package test2;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WebServer {
    private File filePath;
    private File[] fileList;
    private Queue<String> waitingQueueRequests;
    private Queue<File> waitingQueueResponse;

    public static final int MAX_SIZE = 10;

    public WebServer(File filePath) {
        this.filePath = filePath;
        this.fileList = filePath.listFiles();
        this.waitingQueueRequests = new LinkedList<>();
        this.waitingQueueResponse = new LinkedList<>();
    }

    public File[] getFileList() {
        return fileList;
    }

    public synchronized void addReq(String request) {
        while (waitingQueueRequests.size() > MAX_SIZE) {
            try {
                System.out.println("Blocked add");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
        notify();
        waitingQueueRequests.add(request);

    }

    public synchronized String removeReq() {
        while(waitingQueueRequests.isEmpty())
            try {
                System.out.println("Blocked remove");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        notify();
        return waitingQueueRequests.remove();
    }

    public synchronized void addRes(File file) {
        while (waitingQueueResponse.size() > MAX_SIZE) {
            try {
                System.out.println("Blocked add");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
        notify();
        waitingQueueResponse.add(file);
    }

    public synchronized File removeRes() {
        while(waitingQueueResponse.isEmpty())
            try {
                System.out.println("Blocked remove");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        notify();
        return waitingQueueResponse.remove();
    }
}
