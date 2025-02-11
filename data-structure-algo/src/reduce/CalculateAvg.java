package reduce;

import java.util.Arrays;
import java.util.List;

public class CalculateAvg {
    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(2.5, 3.5, 4.5, 5.5);
        double max = numbers.stream().reduce(0.0, (acc, x) -> acc + x);
        System.out.println(max/numbers.size());
    }
}
