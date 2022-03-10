package geekForGeek;

public class ReverseWordInSentenceItHasPoint {

	static String reverseWords(String S) {
		if (S.length() == 0 || S == null)
			return "";
		String words[] = S.split("\\.");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i > 0; i--) {
			// System.out.print(words[i] + ", ");
			sb.append(words[i]).append(".");
		}
		sb.append(words[0]);

		return sb.toString();
	}

	public static int nCr(long n, long r) {
		long a = factorial(n);
		long b = factorial(r);
		long c = factorial(n - r);

		long div = (b * c) % 1000003;
		String result = a / div + "";

		return Integer.valueOf(result);
	}

	private static int factorial(long n) {
		int fac = 1;
		while (n > 0) {
			fac = fac % 1000003;
			fac *= n;
			n -= 1;
		}
		return fac % 1000003;
	}

	public static void main(String[] args) {
		String str = "i.like.this.program.very.much";
		System.out.println(reverseWords(str));
		
		System.out.println(nCr(17, 3));
	}
}
