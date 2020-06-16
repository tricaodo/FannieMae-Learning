package optionals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class __Optional {
    public static void main(String[] args) {
        Optional.ofNullable("jdbc://localhost:8080/users")
                .ifPresentOrElse(url -> System.out.println("Connect to " + url),
                        () -> System.out.println("Failed to connect"));
        // 2. The usage of boxed.
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 6, 2, 7, 3, 9, 12, 11));
        System.out.println("\n========= Before =========");
        list.forEach(num -> System.out.print(num + " "));
        IntStream.range(0, list.size())
                .filter(i -> list.get(i) == 12)
                .boxed()
                .findAny()
                .map(i -> list.remove((int) i));
        System.out.println("\n========= After =========");
        list.forEach(num -> System.out.print(num + " "));
    }
}
