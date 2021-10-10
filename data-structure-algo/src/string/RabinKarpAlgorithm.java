package string;

public class RabinKarpAlgorithm {

	public final static int CHAR_COUNT = 256;

	public static void search(String pat, String txt, int q) {
		int N = txt.length();
		int M = pat.length();
		int p = 0;
		int t = 0;
		int h = 1;
		for (int i = 0; i < M - 1; i++) {
			h = (h * CHAR_COUNT) % q;
			System.out.println("h : " + h);
		}
		for (int i = 0; i < M; i++) {
			System.out.print("(" + CHAR_COUNT + " * " + p + " + " +  pat.charAt(i) + " ASCII is " + (int)pat.charAt(i));
			System.out.print(") % " + q);
			p = (CHAR_COUNT * p + pat.charAt(i)) % q;
			System.out.println(" Hash is :" + p);
			System.out.print("(" + CHAR_COUNT + " * " + t + " + " +  txt.charAt(i) + " ASCII is " + (int)txt.charAt(i));
			System.out.print(") % " + q);
			t = (CHAR_COUNT * t + txt.charAt(i)) % q;
			System.out.println(" Hash is : " + t);
		}
		int j = 0;
		for (int i = 0; i <= N - M; i++) {
			if (p == t) {
				for (j = 0; j < M; j++) {
					if (txt.charAt(i + j) != pat.charAt(j))
						break;
				}
				if (j == M)
					System.out.println("Pattern found at index " + i);
			}
			if (i < N - M) {
				t = ((CHAR_COUNT * (t - txt.charAt(i) * h)) + txt.charAt(i + M)) % q;
				if (t < 0)
					t = (t + q);
			}
		}
	}

	public static void main(String[] args) {
		String text = "Dheeraj was in Army school";
		String pattern = "Army";
		int q = 101;
		System.out.println(text.length() + " " + pattern.length());
		search(pattern, text, q);
	}
}
