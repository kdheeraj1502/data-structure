package backtracking;

import java.util.*;

public class PalindromParitioning {

	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		partition(result, new ArrayList<>(), s, 0);
		return result;
	}

	public static void partition(List<List<String>> result, List<String> temp, String s, int start) {
		if (start == s.length()) {
			result.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				temp.add(s.substring(start, i + 1));
				partition(result, temp, s, i + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String s, int low, int high) {
		while (low < high) {
			if (s.charAt(low) != s.charAt(high))
				return false;
			low++;
			high--;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "aab";
		System.out.println(partition(s));
	}
}
