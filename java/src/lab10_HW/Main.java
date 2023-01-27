package lab10_HW;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Map<String, Integer> map = new HashMap<>();
//        Scanner scanner;
        File directoryPath = new File("/Users/laurentiupomana/Desktop/fac_an_2/object_oriented_programming/src/textFiles");
//        File[] filesList = directoryPath.listFiles();
//        assert filesList != null;
//        for(File file : filesList) {
//            scanner = new Scanner(file);
//            while (scanner.hasNext()) {
//                String st = scanner.next();
//                if (map.containsKey(st))
//                    map.put(st, map.get(st) + 1);
//                else
//                    map.put(st, 1);
//            }
//            scanner.close();
//        }
//        System.out.println(map);

        Reducer reducer = new Reducer(directoryPath);
        Worker worker1 = new Worker(reducer);
        Worker worker2 = new Worker(reducer);
        Worker worker3 = new Worker(reducer);
        Worker worker4 = new Worker(reducer);

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        worker1.join();
        worker2.join();
        worker3.join();
        worker4.join();

//        Worker[] workers = {worker1, worker2, worker3, worker4};
//
//        boolean done = false;
//        while(!done) {
//            done = true;
//            for (Worker worker : workers) {
//                if(worker.isAlive()) {
//                    done = false;
//                    break;
//                }
//            }
//        }

        System.out.println(reducer.getReducerMap().toString());
     }
}
