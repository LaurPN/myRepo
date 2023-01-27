package test;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<String> studentNames;


    public Course(String courseName, ArrayList<String> studentNames) {
        this.courseName = courseName;
        this.studentNames = studentNames;
        ArrayList<String> auxList = new ArrayList<>();

        for (String name : studentNames) {
            if (!auxList.contains(name)) {
                auxList.add(name);
            }
        }

        this.studentNames = auxList;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ArrayList<String> getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(ArrayList<String> studentNames) {
        this.studentNames = studentNames;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +

                '}';
    }
}
