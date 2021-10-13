package string;

public class PalindromeCheck {

	public boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;
		while (start < end && str.charAt(start) == str.charAt(end)) {
			start++;
			end--;
		}
		if (start < end) {
			return false;
		} else
			return true;
	}

	public static void main(String[] args) {
		PalindromeCheck pc = new PalindromeCheck();
		System.out.println(pc.isPalindrome("hello"));
		System.out.println(pc.isPalindrome("eoloe"));
	}
}
