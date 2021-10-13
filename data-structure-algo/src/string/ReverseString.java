package string;

public class ReverseString {

	public String reverse(String str) {
		int start = 0;
		int end = str.length() - 1;
		char ch[] = str.toCharArray();
		return reverseUtil(ch, start, end);
	}
	
	public String reverseUtil(char[] ch, int start, int end) {
		while(start < end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start++;
			end--;
		}
		return new String(ch);
	}
	
	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		System.out.println(rs.reverse("Dheeraj"));
		System.out.println(rs.reverse("dalda"));
	}
}
