package string;

public class ValidPalindrom {

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		String rev = reverse(s.toCharArray());
		if (rev.length() != s.length())
			return false;
		int first = 0;
		int second = 0;
		// a man, a plan, a canal: panama
		// amanap :lanac a ,nalp a ,nam a
		while (first < s.length() && second < rev.length()) {
			if ((s.charAt(first) > '9' || s.charAt(first) < '0') && 
					!(s.charAt(first) >= 'a' && s.charAt(first) <= 'z'))
				first++;
			else if ((rev.charAt(second) > '9' || rev.charAt(second) < '0')
					&& !(rev.charAt(second) >= 'a' && rev.charAt(second) <= 'z'))
				second++;
			else if (s.charAt(first) != rev.charAt(second)) {
				return false;
			} else {
				first++;
				second++;
			}
		}
		return true;
	}

	private String reverse(char[] s) {
		int start = 0;
		int end = s.length - 1;
		while (start < end) {
			char temp = s[start];
			s[start++] = s[end];
			s[end--] = temp;
		}
		return new String(s);
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		ValidPalindrom vp = new ValidPalindrom();
		System.out.println(vp.isPalindrome(s));
	}
}
