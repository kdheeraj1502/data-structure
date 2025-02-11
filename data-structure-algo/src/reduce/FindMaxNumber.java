package reduce;

import java.util.Arrays;
import java.util.List;

public class FindMaxNumber {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 7, 2, 9, 5);
       int max = numbers.stream().reduce(Integer.MIN_VALUE, (acc, x) -> acc > x ? acc : x);
        System.out.println(max);
    }
}
