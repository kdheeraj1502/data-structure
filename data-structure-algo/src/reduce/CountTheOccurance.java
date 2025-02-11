package reduce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountTheOccurance {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 2, 1, 2, 3, 1);
        Map<Integer, Integer> occurrences = numbers.stream()
                .reduce(new HashMap<>(),
                        (map, num) -> {
                            map.put(num, map.getOrDefault(num, 0) + 1);
                            return map;
                        },
                        (map1, map2) -> {
                            map2.forEach((key, value) ->
                                    map1.merge(key, value, Integer::sum));
                            return map1;
                        });

        System.out.println("Occurrences: " + occurrences);


        int[] nums = {1, 2, 3, 1, 2, 1, 2, 3, 1};

        // Counting occurrences using groupingBy collector
        Map<Integer, Long> occurrences1 = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(
                        num -> num, Collectors.counting()));

        // Print the occurrences
        System.out.println("Occurrences: " + occurrences1);
    }
}
