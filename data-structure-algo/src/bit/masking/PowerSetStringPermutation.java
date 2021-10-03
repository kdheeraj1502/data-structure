package bit.masking;

import java.util.*;

public class PowerSetStringPermutation {

	static List<List<String>> getSubset(String[] set, int index) {
		List<List<String>> result;
		if (index < 0) {
			result = new ArrayList<>();
			result.add(new ArrayList<>());
		}

		else {
			result = getSubset(set, index - 1);
			String item = set[index];
			List<List<String>> moreSubsets = new ArrayList<>();

			for (List<String> subset : result) {
				List<String> newSubset = new ArrayList<String>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			result.addAll(moreSubsets);
		}
		return result;
	}

	public static void main(String[] args) {
		// String str = "abc";
		String[] set = { "d", "m", "x", "n" };
		int index = set.length - 1;
		List<List<String>> result = getSubset(set, index);
		System.out.println(result);
	}
}
