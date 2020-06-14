package basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Using Function Interface.
 */
public class LambdaBasic4 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Terry Do", 27),
                new Employee("Johnny Wong", 21),
                new Employee("Kelly Tran", 33),
                new Employee("Harry Lu", 25),
                new Employee("Rey Ruizhu", 29),
                new Employee("Justin Chung", 44)
        );

        // 1. Get all the employees' last name.
        Function<Employee, String> getLastName = employee -> employee.getName().substring(employee.getName().indexOf(" ") + 1);
        System.out.println("\n======== Last Name ========");
        getAName(employees, getLastName);

        // 2. Get all the employees' first name.
        Function<Employee, String> getFirstName = employee -> employee.getName().substring(0, employee.getName().indexOf(" "));
        System.out.println("\n======== First Name ========");
        getAName(employees, getFirstName);

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,100);
        System.out.println(list.stream().reduce(0, Integer::sum));

    }

    private static void getAName(List<Employee> employees, Function<Employee, String> function) {
        employees.forEach(employee -> System.out.println(function.apply(employee)));
    }
}
