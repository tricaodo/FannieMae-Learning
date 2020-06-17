package funtionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class __Function {
    public static void main(String[] args) {
        // 1. The usage of Function.
        Function<Integer, Integer> incrementOneByFunction =
                num -> ++num;
        Function<Integer, Integer> multiplyTenByFunction =
                num -> num * 10;

        // 2. Chain multiple functions into one.
        System.out.println("Value of Function is " + incrementOneByFunction.andThen(multiplyTenByFunction).apply(3));

        // 3. The usage of BiFunction.
        BiFunction<Integer, Integer, Integer> incrementOneAndMultiplyByBiFunction =
                (num1, num2) -> (num1 + 1) * num2;
        System.out.println("Value of BiFunction is " + incrementOneAndMultiplyByBiFunction.apply(4, 100));

        // 4. Transform one list to another list using Function interface.
        System.out.println("\n----------------------");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> newList = convertList().apply(list);
        newList.forEach(num -> System.out.print(num + " "));
    }

    public static Function<List<Integer>, List<Integer>> convertList() {
        return list1 -> list1.stream()
                .map(num -> num * 2)
                .collect(Collectors.toList());
    }
}
