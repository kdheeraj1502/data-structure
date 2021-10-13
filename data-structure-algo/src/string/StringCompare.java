package string;

public class StringCompare {

	public int strComp(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();
		int index = 0;
		int minLen = Math.min(len2, len1);

		while (index < minLen && a.charAt(index) == b.charAt(index)) {
			index++;
		}
		if (index == len1 && index == len2)
			return 0;
		else if (index == len1)
			return -1;
		else if (index == len2)
			return 1;
		else
			return a.charAt(index) - b.charAt(index);
	}

	public static void main(String[] args) {
		StringCompare sc = new StringCompare();
		System.out.println(sc.strComp("dhee", "dheeraj"));
	}
}
