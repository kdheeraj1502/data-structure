package string;

public class ToLowerCase {

	public char convert(char c) {
		if(c >= 65 && c <= (65 + 25)) {
			c = (char)(c + 32);
		}
		return c;
	}
	public static void main(String[] args) {
		ToLowerCase tuc = new ToLowerCase();
		System.out.println(tuc.convert('G'));
	}
}
