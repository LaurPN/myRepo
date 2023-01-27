package test2;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File path = new File("/Users/laurentiupomana/Desktop/fac_an_2/object_oriented_programming/src/textFiles");

        WebServer webServer = new WebServer(path);

        Client c1 = new Client(webServer, "file1.txt");
        Client c2 = new Client(webServer, "file2.txt");
        Client c3 = new Client(webServer, "file3.txt");
        Client c4 = new Client(webServer, "file4.txt");
        Client c5 = new Client(webServer, "file5.txt");

        Worker w1 = new Worker(webServer);
        Worker w2 = new Worker(webServer);
        Worker w3 = new Worker(webServer);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

        w1.start();
        w2.start();
        w3.start();
    }
}
