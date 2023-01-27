package lab5;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Employee implements Comparable{
    private String name;
    private String CNP;
    private LocalDate hiringDate;
    private String specialization;
    private Double Salary;

    public Employee(String name, String CNP, LocalDate hiringDate, String specialization, Double salary) {
        this.name = name;
        this.CNP = CNP;
        this.hiringDate = hiringDate;
        this.specialization = specialization;
        Salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", CNP='" + CNP + '\'' +
                ", hiringDate=" + hiringDate +
                ", specialization='" + specialization + '\'' +
                ", Salary=" + Salary +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Employee))
            return false;
        Employee tmp = (Employee) o;
        return this.name.equals(tmp.getName()) && this.CNP.equals(tmp.getCNP()) && this.specialization.equals(tmp.getSpecialization()) && Objects.equals(this.Salary, tmp.getSalary()) && this.hiringDate.equals(tmp.getHiringDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, CNP, hiringDate, specialization, Salary);
    }

    @Override
    public int compareTo(Object o) {

        Employee tmp = (Employee) o;
        return this.CNP.compareTo(tmp.CNP);
    }


}
