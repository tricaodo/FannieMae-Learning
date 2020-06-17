package funtionalinterface;

import models.Gender;
import models.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class __Supplier {
    public static void main(String[] args) {

        // 1. The usage of Supplier.
        List<Person> people = listSupplier.get();
        people.stream()
                .filter(person -> person.getName().startsWith("J"))
                .forEach(System.out::println);
    }

    static Supplier<List<Person>> listSupplier = ()
            -> Arrays.asList(
            new Person("John", Gender.MALE),
            new Person("Alice", Gender.FEMALE),
            new Person("Luis", Gender.MALE),
            new Person("Alex", Gender.MALE),
            new Person("Jessica", Gender.FEMALE),
            new Person("Jason", Gender.MALE)
    );
}
