package lab5;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            employeeArrayList.add(new Employee("Andrei Pop", "5021205340449", LocalDate.of(random.nextInt(1960,2022), random.nextInt(1, 12), random.nextInt(1, 28)), "fabiz", random.nextDouble(3000,15000)));
        }
        employeeArrayList.add(new Employee("Andrei Pop", "5021205340449",  LocalDate.of(2002, Calendar.MARCH,2), "fabiz", 13000.00));
        employeeArrayList.add(new Employee("Andrei Pop", "5021205340449", LocalDate.of(2002, Calendar.MARCH,2), "fabiz", 13000.00));
        ListIterator<Employee> iterator = employeeArrayList.listIterator(employeeArrayList.size());

//        System.out.println(employeeArrayList + "\n");

        int count = 0;
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
            count++;
            if (count == employeeArrayList.size() / 2) {
                iterator.add(new Employee("Laurentiu Pomana", "5021205340449", LocalDate.of(2002, Calendar.MARCH, 2), "fabiz", 13000.00));
            }

        }


        System.out.println(employeeArrayList + " \n");

        Set<Employee> employeeSet = new HashSet<>(employeeArrayList);

        Iterator<Employee> it = employeeSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next() + " ");
        }

        System.out.println("Problema 2: ");

        employeeArrayList.add(new Employee("Catalin Peicu", "5021205340549",  LocalDate.of(2002, Calendar.MARCH,4), "fabiz", 13000.00));
        employeeArrayList.add(new Employee("Gavril Bogdan", "5041205340449",  LocalDate.of(2002, Calendar.MARCH,12), "fabiz", 13000.00));


        TreeSet<Employee> set = new TreeSet<>(employeeArrayList);

        for (Employee employee : set) {
            System.out.println(employee);
        }

        Map<String,Employee> map = new HashMap<>();
        for (Employee employee : set) {
            map.put(employee.getName(), employee);
        }

        Scanner cin = new Scanner(System.in);

        System.out.println(map.get(cin.nextLine()));

        cin.close();
    }
}
