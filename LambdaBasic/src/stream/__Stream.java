package stream;

import models.Gender;
import models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class __Stream {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(listSupplier.get());

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

        // 4. Found a specific person and return.
        Optional<Person> matchingPerson = people.stream()
                .filter(person -> person.getName().equals("Jessica"))
                .findFirst();
        Person foundPerson = matchingPerson.orElse(null);
        System.out.println("Found person: " + foundPerson);


        // 5. Count the names' length.
        people.stream()
                .map(Person::getName)
                .forEach(name -> System.out.println(name + " - " + name.length()));
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
