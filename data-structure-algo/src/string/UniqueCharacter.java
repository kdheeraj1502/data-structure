package string;

import java.util.Arrays;

public class UniqueCharacter {

	public boolean hasUnique(String str) {
		int bit[] = new int[26];
		Arrays.fill(bit, 0);
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				index = (ch - 'A');
			} else if (ch >= 'a' && ch <= 'z') {
				index = (ch - 'a');
			} else {
				return false;
			}
			if (bit[index] != 0)
				return false;
			bit[index] = 1;
		}
		return true;
	}

	public static void main(String[] args) {
		UniqueCharacter uc = new UniqueCharacter();
	//	System.out.println(uc.hasUnique("Dheeraj"));
		System.out.println(uc.hasUnique("nique"));
	}
}
