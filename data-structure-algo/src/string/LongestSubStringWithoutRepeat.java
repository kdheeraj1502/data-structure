package string;

import java.util.*;

public class LongestSubStringWithoutRepeat {

	public static int lengthOfLongestSubstring(String s) {
		int winStart = 0;
		int winEnd = 0;
		int len = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			if (map.containsKey(ch)) {
				winStart = Math.max(winStart, map.get(ch) + 1);
			}
			len = Math.max(len, winEnd - winStart + 1);
			map.put(ch, winEnd);
			winEnd++;
		}
		return len;
	}

	static final int NO_OF_CHARS = 256;

	public static int longestUniqueSubsttr(String str) {
		int n = str.length();
		int res = 0;
		int[] lastIndex = new int[NO_OF_CHARS];
		Arrays.fill(lastIndex, -1);
		int start = 0;
		for (int end = 0; end < n; end++) {
			// index plus 1
			start = Math.max(start, lastIndex[str.charAt(end)] + 1);
			res = Math.max(res, end - start + 1);
			lastIndex[str.charAt(end)] = end;
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "dvdf";
		int[] lastIndex = new int[NO_OF_CHARS];
		for(int i =0; i < s.length(); i++) {
			lastIndex[s.charAt(i)] = s.charAt(i);
		}
		//System.out.println(Arrays.toString(lastIndex));
		// System.out.println(lengthOfLongestSubstring(s));
		System.out.println(longestUniqueSubsttr(s));

	}
}
