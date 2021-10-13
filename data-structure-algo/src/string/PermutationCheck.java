package string;

import java.util.Arrays;

public class PermutationCheck {

	public boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		int bit[] = new int[256];
		Arrays.fill(bit, 0);
		for (int i = 0; i < str1.length(); i++) {
			int ch = str1.charAt(i);
			bit[ch]++;
			ch = str2.charAt(i);
			bit[ch]--;
		}
		for (int i = 0; i < bit.length; i++) {
			if (bit[i] != 0)
				return false;
		}
		return true;
	}

	public boolean isPermutation_self(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		int bit[] = new int[256];
		Arrays.fill(bit, 0);
		for(int i = 0; i < str1.length(); i++) {
			bit[str1.charAt(i)]++;
			bit[str2.charAt(i)]--;
		}
		for(int i = 0; i < bit.length; i++) {
			if(bit[i] != 0) return false; 
		}
		return true;
	}

	public static void main(String[] args) {
		PermutationCheck pc = new PermutationCheck();
		System.out.println(pc.isPermutation("apple", "plepa"));
		System.out.println(pc.isPermutation("apple", "ulepa"));
		
		System.out.println(pc.isPermutation_self("apple", "plepa"));
		System.out.println(pc.isPermutation_self("apple", "ulepa"));
	}
}
