package string;

public class KnuthMorrisStringMatch {

	public static void KMPSearch(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();
		int lps[] = new int[M];
		int j = 0; // index for pat[]
		computeLPS(pat, M, lps);
		int i = 0;
		// "Dheeraj was in Army school"
		// "Army";
		while (i < N) {
			System.out.println(pat.charAt(j) + " == " + txt.charAt(i));
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == M) {
				System.out.println("Found pattern " + "at index " + (i - j));
				j = lps[j - 1];
			} else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
	}

	private static void computeLPSArray(String pat, int M, int lps[]) {
		int index = 0;
		int i = 1;
		lps[0] = 0;
		while (i < M) {
			System.out.println("Pat at index " + index + " : " + pat.charAt(index) + " == " + pat.charAt(i)
					+ " and Pat at i " + i);
			if (pat.charAt(index) == pat.charAt(i)) {
				index++;
				lps[i] = index;
				i++;
			} else {
				if (index != 0) {
					index = lps[index - 1];
				} else {
					lps[i] = index;
					i++;
				}
			}
		}
	}

	private static void computeLPS(String pat, int M, int lps[]) {
		int index = 0;
		int i = 1;
		while (i < M) {
			if (pat.charAt(index) == pat.charAt(i)) {
				index = index + 1;
				lps[i] = index;
				i++;
			} else {
				if (index != 0) {
					index = lps[index - 1];
				} else {
					lps[i] = index;
					i++;
				}
			}
		}
	}

	public static void KMPSearch_self(String pat, String txt) {
		int n = txt.length();
		int m = pat.length();
		int i = 0;
		int j = 0;
		int lps[] = new int[m];
		computeLPS_self(pat, m, lps);
		while (i < n) {
			if (txt.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}
			if (j == m) {
				System.out.println("Math found at " + (i - j));
				j = lps[j - 1];
			} else if (i < n && txt.charAt(i) != pat.charAt(j)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}

	}

	private static void computeLPS_self(String pat, int m, int lps[]) {
		int index = 0;
		int i = 1;
		while (i < m) {
			if (pat.charAt(index) == pat.charAt(i)) {
				index++;
				lps[i] = index;
				i++;
			} else {
				if (index != 0) {
					index = lps[index - 1];
				} else {
					lps[i] = index;
					i++;
				}
			}
		}
	}

	public static void main(String args[]) {
		String text = "DheerAj was in Army school";
		String pattern = "Army";
		KMPSearch_self(pattern, text);
	}

}
