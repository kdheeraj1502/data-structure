package dynamic.programming.knapsack;

public class SubSetSumProblemSelf {

	private int maxSum;
	private int nums[];
	private boolean[][] knapSackTable;
	private boolean result;

	public SubSetSumProblemSelf(int maxSum, int nums[]) {
		this.maxSum = maxSum;
		this.nums = nums;
		this.knapSackTable = new boolean[nums.length + 1][maxSum + 1];
		
	}

	public boolean solve() {
		for(int i = 0; i < nums.length + 1; i++)
			knapSackTable[i][0] = true;
		
		for(int rowIndex = 1; rowIndex < nums.length + 1; rowIndex++) {
			for(int colIndex = 1; colIndex < maxSum + 1; colIndex++) {
				if(colIndex < nums[rowIndex - 1]) {
					knapSackTable[rowIndex][colIndex] = knapSackTable[rowIndex - 1][colIndex];
				} else {
					if(knapSackTable[rowIndex - 1][colIndex] == true) {
						knapSackTable[rowIndex][colIndex] = knapSackTable[rowIndex - 1][colIndex];
					} else {
						knapSackTable[rowIndex][colIndex] = knapSackTable[rowIndex - 1][colIndex - nums[rowIndex - 1]];
					}
				}
			}
		}
		return knapSackTable[nums.length][maxSum];
	}
	
	public boolean solve_self() {
		for(int i = 0; i < nums.length + 1; i++)
			knapSackTable[i][0] = true;
		
		for(int i  =1; i < nums.length + 1; i++) {
			for(int j = 1;j < maxSum + 1; j++) {
				if(j < i) {
					knapSackTable[i][j] = knapSackTable[i - 1][j];
				} else {
					if(knapSackTable[i - 1][j] = true) {
						knapSackTable[i][j] = knapSackTable[i - 1][j];
					} else {
						knapSackTable[i][j] = knapSackTable[i - 1][j - nums[i - 1]];
					}
				}
			}
		}
		return knapSackTable[nums.length][maxSum];
	}

	public static void main(String[] args) {
		int S[] = { 5, 2, 3, 1 };
		int sum = 9;

		SubSetSumProblemSelf ssp = new SubSetSumProblemSelf(sum, S);
		System.out.println(ssp.solve_self());
	}
}
