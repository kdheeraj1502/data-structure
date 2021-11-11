package dynamic.programming;

/**
 * 
 * IN DP ROW CONSIST SAME STRING AND COLUMN CONSIST SAME STRING
 * 
 * CONSIDER CHARACTER IN SUCH A WAY
 * 	  A   B     C     D
 *  A A
 *  B      AB     ABC  ABCD
 *  C        AB 
 *  D     A
 * @author dheerajkumar02
 *
 */
public class LongestPalindromSubSequence {
	String s;
	int dp[][];

	public LongestPalindromSubSequence(String s) {
		this.s = s;
		this.dp = new int[s.length()][s.length()];
	}
	
	public int countPalindrom() {
		boolean dp[][] = new boolean[s.length()][s.length()];
		for(int i = 0; i < dp.length; i++) {
			dp[i][i] = true;
		}
		for(int i = 0; i < dp.length - 1; i++) {
			if(s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
			} else {
				dp[i][i + 1] = false;
			}
		}
		int length = 3;
		while(length <= dp.length) {
			for(int i = 0; i <= (s.length() - length); i++) {
				int j = i + length - 1;
				if(s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
			length++;
		}
		int count = 0;
		for(int i = 0; i < dp.length; i++) {
			for(int j = i; j < dp.length; j++) {
				if(dp[i][j])
					count++;
			}
		}
		return count;
	}
	

	public int maxPalindrom() {
		int n = s.length();
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		for (int i = 0; i <= n - 2; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 2;
			} else {
				dp[i][i + 1] = 1;
			}
		}
		int length = 3;
		while (length <= dp.length) {
			for (int i = 0; i <= (n - length); i++) {
				int j = i + length - 1;
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
			length++;
		}
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		String s = "agbdba";
		String output = "abdba";
		LongestPalindromSubSequence lps = new LongestPalindromSubSequence(s);
		System.out.println(lps.maxPalindrom());
		System.out.println(lps.countPalindrom());
	}
}
