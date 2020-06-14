package basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaBasic3 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Terry Do", 27),
                new Employee("Johnny Wong", 21),
                new Employee("Kelly Tran", 33),
                new Employee("Harry Lu", 25),
                new Employee("Rey Ruizhu", 29),
                new Employee("Justin Chung", 44)
        );

        // 1. Employee whose ages are greater than 30.
        System.out.println("Employees whose age are greater than 30.");
        System.out.println("=======================================");
        employees.forEach(employee -> {
            if (employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        });

        // 2. Employee whose ages are 30 or younger.
        System.out.println("\nEmployees whose age are 30 or younger.");
        System.out.println("=======================================");
        employees.stream()
                .filter(employee -> employee.getAge() <= 30)
                .forEach(employee -> System.out.println(employee.getName()));

        // 3. Reuse the 2 above examples.
        printEmployeesConditionally(employees,
                "\nEmployees whose ages are greater than 20 and less than 26.",
                employee -> employee.getAge() > 20 && employee.getAge() < 26);
        printEmployeesConditionally(employees,
                "\nEmployee whose ages are greater than 30.",
                employee -> employee.getAge() > 30);
    }

    private static void printEmployeesConditionally(List<Employee> employees, String banner, Predicate<Employee> condition) {
        System.out.println(banner);
        System.out.println("==========================================");
        for (Employee employee : employees) {
            if (condition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
