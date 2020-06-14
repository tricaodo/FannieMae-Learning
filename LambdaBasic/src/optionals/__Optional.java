package optionals;

import java.util.List;
import java.util.Optional;

public class __Optional {
    public static void main(String[] args) {
        Optional.ofNullable("jdbc://localhost:8080/users")
                .ifPresentOrElse(url -> System.out.println("Connect to " + url),
                        () -> System.out.println("Failed to connect"));

        List<Integer> list = List.of(4, 6, 2, 7, 3, 9, 12, 11);
        int total = list.stream().reduce(0, Integer::sum);
        System.out.println("Total is " + total);
    }
}
