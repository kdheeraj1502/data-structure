package dynamic.programming.knapsack;

/**
 *  // if N = 0 then 0, 
 *  // if M = 0 then 0, 
 *  // max { S[i - 1][j], p(i) + S[i - 1][j - i]}
 *  // if(i <= j) S[i - 1][j] if(i > j)
 * 
 * @author dheerajkumar02
 *
 */
public class RodCuttingProblem {
	
	// Maximum length of the Rod 
	private int rodLength;
	
	/// price array
	private int[] prices;
	private int totalBenefit;
	
	// Num of pieces and num of length
	// Dynamic Programming 2 D array
	private int knapSackTable[][];

	
	public RodCuttingProblem(int rodLength, int[] prices) {
		this.rodLength = rodLength;
		this.prices = prices;
		// row = Num of pieces and col = num of length
		// For Ex: 0, 1, 2, 3, 4, 5 piece length = 0, 1 ,2 ,3 ,4, 5
		this.knapSackTable = new int[prices.length + 1][rodLength + 1];
	}

	public int solve() {
		for (int i = 1; i < prices.length; i++) {
			for (int j = 1; j < rodLength + 1; j++) {
				if (i <= j) {
					knapSackTable[i][j] = Math.max(knapSackTable[i - 1][j], prices[i] + knapSackTable[i - 1][j - i]);
				} else {
					knapSackTable[i][j] = knapSackTable[i - 1][j];
				}
			}
		}
		totalBenefit = knapSackTable[prices.length - 1][rodLength];
		return totalBenefit;
	}

	public void showResult() {
		for (int rowIndex = prices.length - 1, colIndex = rodLength; rowIndex > 0;) {
			if (knapSackTable[rowIndex][colIndex] != 0 && knapSackTable[rowIndex][colIndex] != knapSackTable[rowIndex - 1][colIndex]) {
				System.out.println("We take item : #" + rowIndex);
				colIndex = colIndex - rowIndex;
			} else {
				rowIndex--;
			}
		}
	}

	public static void main(String[] args) {
		int rodLength = 5; // pipe length
		int[] prices = { 0, 2, 5, 7, 3, 9 };
		RodCuttingProblem rcp = new RodCuttingProblem(rodLength, prices);
		System.out.println(rcp.solve());
		rcp.showResult();
	}
}
