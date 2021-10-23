package dynamic.programming.knapsack;

/**
 * 
 * * if j == 0 then true,... if required sum is 0
 * * if i == 0, then false..if we have no item
 * 
 * * S[i][j] = S[i - 1][j] if S[i - 1][j] is true // calculate sum with i - 1 and sum is j
 * 
 * * S[i][j] = S[i - 1][j - A[i - 1]] if S[i - 1][j] else // calculate sum with i - 1 and sum is j - 1
 * 
 * @author dheerajkumar02
 *
 */
public class SubSetSumProblem {

	private boolean knapSackTable[][];
	private int S[];
	private int sum;
	
	public SubSetSumProblem(int[] S, int sum) {
		this.S = S;
		this.sum = sum;
		this.knapSackTable = new boolean[S.length + 1][sum + 1];
	}
	
	public boolean solve() {
		for(int i = 0; i < S.length + 1; i++)
			knapSackTable[i][0] = true;
		
		for(int rowIndex = 1; rowIndex < S.length + 1; rowIndex++) {
			for(int colIndex = 1; colIndex < sum + 1; colIndex++) {
				if(colIndex < S[rowIndex - 1]) {
					knapSackTable[rowIndex][colIndex] = knapSackTable[rowIndex - 1][colIndex];
				} else {
					if(knapSackTable[rowIndex - 1][colIndex] == true) {
						knapSackTable[rowIndex][colIndex] = knapSackTable[rowIndex - 1][colIndex];
					} else {
						knapSackTable[rowIndex][colIndex] = knapSackTable[rowIndex - 1][colIndex - S[rowIndex - 1]];
					}
				}
			}
		}
		return knapSackTable[S.length][sum];
	}
	
	public void showResult() {
		int colIndex = sum;
		int rowIndex = S.length;
		while(colIndex > 0 || rowIndex > 0) {
			if(knapSackTable[rowIndex][colIndex] == knapSackTable[rowIndex - 1][colIndex]) {
				rowIndex--;
			} else {
				System.out.println("We take " + S[rowIndex - 1]);
				colIndex = colIndex - S[rowIndex - 1];
				rowIndex--;
			}
		}
	}
	
	public static void main(String[] args) {
		int S[] = { 5, 2, 3, 1};
		int sum= 9;
		SubSetSumProblem ssp = new SubSetSumProblem(S, sum);
		System.out.println(ssp.solve());
		ssp.showResult();
		
	}
}
