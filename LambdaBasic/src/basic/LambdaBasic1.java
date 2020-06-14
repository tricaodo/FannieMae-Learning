package basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaBasic1 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Terry Do", 27),
                new Employee("Johnny Wong", 21),
                new Employee("Kelly Tran", 33),
                new Employee("Harry Lu", 25)
        );

        System.out.println("\n======== Original List ========");
        printEmployees(employees);

        System.out.println("\n======== Sorted List ========");
        employees.sort(Comparator.comparing(Employee::getName));

        printEmployees(employees);
    }

    private static void printEmployees(List<Employee> employees){
        employees.forEach(System.out::println);
    }

}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}