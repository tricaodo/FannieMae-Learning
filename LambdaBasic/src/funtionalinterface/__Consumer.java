package funtionalinterface;

import models.Person;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static funtionalinterface.__Collections.initList;

public class __Consumer {
    public static void main(String[] args) {
        List<Person> people = initList();

        // 1. The usage of Consumer.
        Consumer<Person> showInfo = System.out::println;
        showInfo.accept(people.get(0));

        // 2. The usage of BiConsumer.
        BiConsumer<Person, Boolean> showInfoWithoutGender = (person, showGender) -> {
            System.out.println("The customer's name is " + person.getName()
                    + " - Gender: "
                    + (showGender ? person.getGender() : " ***"));
        };
        showInfoWithoutGender.accept(people.get(1), false);
    }
}
