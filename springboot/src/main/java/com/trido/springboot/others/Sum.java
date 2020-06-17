package com.trido.springboot.others;

import java.util.Arrays;
import java.util.List;

public class Sum {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        int sum = list.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum is " + sum);
    }
}
