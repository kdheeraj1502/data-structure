package string;

import java.util.Arrays;

public class StringShuffle {

	public String restoreString(String s, int[] indices) {
		char ch[] = new char[indices.length];
		for (int i = 0; i < indices.length; i++) {
			ch[indices[i]] = s.charAt(i);
		}
		return new String(ch);
	}

	public char[] restoreString(String s) {
		char character[] = new char[s.length()];
		int index = -1;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9') {
				index = i;
				break;
			}
		}
		int first = 0;
		int second = index;
		int j = 0;
		while (first < index && second < s.length()) {
			character[j++] = s.charAt(first++);
			character[j++] = s.charAt(second++);
		}
		return character;
	}

	public static void main(String[] args) {
		StringShuffle ss = new StringShuffle();
		String str = "codeleet";
		int[] indices = { 4, 5, 6, 7, 0, 2, 1, 3 };
		System.out.println(ss.restoreString(str, indices));

		System.out.println(Arrays.toString(ss.restoreString("ABCDE12345")));
	}
}
