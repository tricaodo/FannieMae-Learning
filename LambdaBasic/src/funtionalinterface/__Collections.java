package funtionalinterface;

import models.Gender;
import models.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class __Collections {
    public static void main(String[] args) {
        List<Person> people = initList();
        // 1. Get all females.
        people.stream().filter(person -> Gender.FEMALE.equals(person.getGender()))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static List<Person> initList() {
        return Arrays.asList(
                new Person("John", Gender.MALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Luis", Gender.MALE),
                new Person("Alex", Gender.MALE),
                new Person("Jessica", Gender.FEMALE),
                new Person("Jason", Gender.MALE)
        );
    }
}
