package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Moodle {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public Moodle(ArrayList<Student> students, ArrayList<Course> courses) {
        this.students = students;
        this.courses = courses;
    }

    public Map<Student, Integer> toMap() {
        Map<Student, Integer> map = new HashMap<>();
        for (Student student : students) {
                if (!map.containsKey(student)) {
                    map.put(student, student.getCourses().size());
                }
            }
        return map;
    }
}
