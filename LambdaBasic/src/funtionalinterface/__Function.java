package funtionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

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
    }
}
