package test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        ArrayList<Course> c = new ArrayList<>();
        Random random = new Random();
        students.add("Andrei");
        students.add("Laurentiu");
        students.add("Darius");
        Course c1 = new Course("sm", students);
        Course c2 = new Course("oop", students);
        c.add(c1);
        c.add(c2);
        Student s1 = new Student("Andrei", "andrei@gmail.com", c);
        Student s2 = new Student("Laurentiu", "laurentiu@gmail.com", c);
        Student s3 = new Student("Darius", "darius@gmail.com", c);
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);

        Moodle moodle = new Moodle(studentArrayList, c);

        s1.getCourses();
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s3));
        System.out.println(s2.compareTo(s1));
        for (Map.Entry<Course, Double> set : s1.getGrades().entrySet()) {
            set.setValue(random.nextDouble(5,10));
        }
        System.out.println(s1.getAverageGrade());
        System.out.println(moodle.toMap());
    }
}
