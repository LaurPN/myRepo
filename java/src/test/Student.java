package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student implements Comparable<Student>{
    private String username;
    private String email;
    private ArrayList<Course> courses;
    private HashMap<Course, Double> grades = new HashMap<>();

    public Student(String username, String email, ArrayList<Course> courses) {
        this.username = username;
        this.email = email;
        this.courses = courses;
        for (Course course : courses) {
            if (!grades.containsKey(course)) {
                grades.put(course, 0.0);
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void setGrades(String courseName, Double grade) {
        Course auxCourse = null;
        for (Course course : courses) {
            if (Objects.equals(course.getCourseName(), courseName)) {
                auxCourse = course;
            }
        }
        if (grades.containsKey(auxCourse)) {
            grades.replace(auxCourse, grade);
        }
    }

    public HashMap<Course, Double> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        double average = 0.0;
        int index = 0;


        for (Map.Entry<Course, Double> set : grades.entrySet()) {
            if (set.getValue() >= 5) {
                index++;
                average+=set.getValue();
            }
        }
        if (index != 0) {
            return average / index;
        }
        return average;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", courses=" + courses +
                ", grades=" + grades +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.username.compareTo(o.username);
    }
}
