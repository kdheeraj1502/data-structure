package string;

import java.util.*;

public class StringPermuation {

	static int count = 1;

	public static List<List<Character>> permute(char ch[], int max, List<List<Character>> result) {
		if (max == 1) {
			System.out.print(ch);
			System.out.println(" : " + (count++));
			List<Character> curr = new ArrayList<>();
			for(char c : ch) {
				curr.add(c);
			}
			result.add(curr);
			return result;
		}
		for (int i = -1; i < max - 1; i++) {
			if (i != -1) {
				char temp = ch[i];
				ch[i] = ch[max - 1];
				ch[max - 1] = temp;
			}
			permute(ch, max - 1, result);
			if (i != -1) {
				char temp = ch[i];
				ch[i] = ch[max - 1];
				ch[max - 1] = temp;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "Dheeraj";
		List<List<Character>> result = permute(str.toCharArray(), str.length(), new ArrayList<>());
	//	System.out.println(result);
		System.out.println(result.size());
	}
}
