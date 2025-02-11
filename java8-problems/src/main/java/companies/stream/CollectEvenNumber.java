package companies.stream;

import java.util.List;
import java.util.stream.Collectors;

public class CollectEvenNumber {

	public static List<Integer> evenNum(List<Integer> nums){
		return nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
	}
}
