package string;

public class StringMatchBrutForce {

	public static int stringMatch(String T, String P) {
		int n = T.length();
		int m = P.length();
		for(int i = 0; i <= n - m; i++) {
			int j = 0;
			while(j < m && P.charAt(j) == T.charAt(i + j)) {
				j++;
			}
			if(j == m) return i;
		}
		return -1;
		
	}
	public static void main(String[] args) {
		String text = "Dheeraj was in Army school";
		String pattern = "Army";
		System.out.println(stringMatch(text, pattern));
	}
}
