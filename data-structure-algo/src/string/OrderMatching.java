package string;

public class OrderMatching {

	public boolean orderMatch(String text, String pat) {
		return orderMatch(text.toCharArray(), pat.toCharArray(), 0, 0);
	}

	private boolean orderMatch(char[] text, char[] pat, int i, int j) {
		if (i == text.length && j == pat.length)
			return true;
		if (i != text.length && j == pat.length)
			return true;
		if (i == text.length && j != pat.length)
			return false;
		if (text[i] == pat[j]) {
			return orderMatch(text, pat, i + 1, j + 1);
		} else if (text[i] != pat[j]) {
			return orderMatch(text, pat, i + 1, j);
		}
		return false;
	}

	public static void main(String[] args) {
		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String pattern = "JOTST";
		OrderMatching om = new OrderMatching();
		System.out.println(om.orderMatch(text, pattern));
		System.out.println(om.orderMatch_book(text, pattern));
	}

	public boolean orderMatch_book(String text, String pat) {
		char[] source = text.toCharArray();
		char[] des = pat.toCharArray();
		int j = 0;
		for (int i = 0; i < source.length; i++) {
			if (source[i] == des[j]) {
				j++;
			}
			if (j == pat.length()) {
				return true;
			}
		}
		return false;
	}
}
