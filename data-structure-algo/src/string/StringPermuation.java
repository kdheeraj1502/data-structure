package string;

import java.util.*;
import java.util.stream.Collectors;

public class StringPermuation {

	static int count = 1;

	public static List<List<Character>> permute(char ch[], int max, List<List<Character>> result) {
		if (max == 1) {
			System.out.print(ch);
			System.out.println(" : " + (count++));
			List<Character> curr = new ArrayList<>();
			for (char c : ch) {
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
		// List<List<Character>> result = permute(str.toCharArray(), str.length(), new
		// ArrayList<>());
		// System.out.println(result);
		// System.out.println(result.size());

		Character[] charObjectArray = str.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
		List<List<Character>> result = permute_self((charObjectArray));
		System.out.println(result.size());
	}

	public static List<List<Character>> permute_self(Character ch[]) {
		List<List<Character>> result = new ArrayList<>();
		permute_self(ch, result, 0);
		return result;
	}

	public static void permute_self(Character ch[], List<List<Character>> result, int index) {
		if (index == ch.length - 1) {
			result.add(Arrays.stream(ch).collect(Collectors.toList()));
		} else {
			for (int i = index; i < ch.length; i++) {
				ch = swap(ch, index, i);
				permute_self(ch, result, index + 1);
				ch = swap(ch, index, i);
			}
		}
	}

	private static Character[] swap(Character ch[], int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return ch;
	}
}
