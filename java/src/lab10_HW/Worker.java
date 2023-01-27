package lab10_HW;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Worker extends Thread{
    private Reducer reducer;
    private Map<String, Integer> map;

    public Worker(Reducer reducer) {
        super();
        this.reducer = reducer;
        this.map = new HashMap<>();
    }

    @Override
    public void run() {
        while (true) {
            File file = reducer.getNextFile();
            if(file == null)
                break;
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (true) {
                assert scanner != null;
                if (!scanner.hasNext()) break;
                String st = scanner.next();
                if (map.containsKey(st))
                    map.put(st, map.get(st) + 1);
                else
                    map.put(st, 1);
            }
            scanner.close();
        }
//        System.out.println(map.toString());
        reducer.mergeMaps(map);
    }
}
