package reduce;

import java.util.Arrays;
import java.util.List;

public class FindLongestString {
    public static void main(String[] args) {
            List<String> numbers = Arrays.asList("apple", "banana", "orange", "grapefruit");
            String longest = numbers.stream().reduce("",
                    (acc, x) -> acc.length() > x.length()? acc : x);
            System.out.println(longest);

    }
}
