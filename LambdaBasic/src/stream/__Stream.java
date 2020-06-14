package stream;

import models.Gender;
import models.Person;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class __Stream {
    public static void main(String[] args) {
        List<Person> people = listSupplier.get();

        // 1. Print all genders.
        people.stream()
                .map(Person::getGender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        // 2. Print all the names' length.
        people.stream()
                .map(Person::getName)
                .mapToInt(String::length)
                .forEach(System.out::println);

        // 3. Check if the list has female gender.
        boolean hasFemale = people.stream()
                .allMatch(person -> person.getGender().equals(Gender.FEMALE));
        System.out.println(hasFemale);

    }

    static Supplier<List<Person>> listSupplier = ()
            -> List.of(
            new Person("John", Gender.MALE),
            new Person("Alice", Gender.FEMALE),
            new Person("Luis", Gender.MALE),
            new Person("Alex", Gender.MALE),
            new Person("Jessica", Gender.FEMALE),
            new Person("Jason", Gender.MALE)
    );
}
