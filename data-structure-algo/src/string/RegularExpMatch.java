package string;

/**
 * To Match regular exp with a string ? for single character match * for zero,
 * single or multiple character match
 * 
 * @author dheerajkumar02
 *
 */
public class RegularExpMatch {

	public boolean match(String exp, String str) {
		return match(exp.toCharArray(), str.toCharArray(), 0, 0);
	}

	private boolean match(char[] exp, char[] str, int i, int j) {
		if (i == exp.length && j == str.length)
			return true;
		if ((i == exp.length && j != str.length) || (i != exp.length && j == str.length))
			return false;
		if (exp[i] == '?' || exp[i] == str[j]) {
			return match(exp, str, i + 1, j + 1);
		} else if (exp[i] == '*') {
			return (match(exp, str, i, j + 1) || match(exp, str, i + 1, j) || match(exp, str, i + 1, j + 1));
		}
		return false;
	}

	public static void main(String[] args) {
		RegularExpMatch rem = new RegularExpMatch();
		System.out.println(rem.match("*llo,?World?", "Hello, World!"));
	}
}
