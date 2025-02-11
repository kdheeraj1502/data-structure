package reduce;

import java.util.Arrays;
import java.util.List;

public class ConcatinateString {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("Hello", " ", "World", "!");

        String concat = numbers.stream().reduce("", (acc, x) -> acc + x);
        System.out.println(concat);

    }
}
