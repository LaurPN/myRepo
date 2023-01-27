package lab10_HW;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Reducer {
    private Map<String, Integer> reducerMap;
    private File filePath;
    private File[] filesList;
    private int id;

    public Reducer(File filePath) {
        this.reducerMap = new HashMap<>();
        this.filePath = filePath;
        this.filesList = filePath.listFiles();
        this.id = 0;
    }

    public synchronized void mergeMaps(Map<String, Integer> auxMap) {
        auxMap.forEach((key, value) -> reducerMap.merge(key, value, Integer::sum));
    }

    public synchronized File getNextFile() {
        if (this.id > filesList.length - 1)
            return null;
        File auxFile = this.filesList[this.id];
        this.id++;
        return auxFile;
    }

    public Map<String, Integer> getReducerMap() {
        return reducerMap;
    }
}
