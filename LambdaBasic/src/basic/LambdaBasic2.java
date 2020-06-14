package basic;

public class LambdaBasic2 {
    public static void main(String[] args) {
        String s1 = "hello ";
        String s2 = "world";

        String s3 = doStringStuff((a, b) ->
                        a.concat(b).toUpperCase()
                , s1, s2);

        System.out.println(s3);
    }

    private static String doStringStuff(UpperAndConcat operation, String s1, String s2) {
        return operation.upperAndConcat(s1, s2);
    }
}

interface UpperAndConcat {
    String upperAndConcat(String s1, String s2);
}
