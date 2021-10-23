package recursion;

import java.util.*;



/// UNSOLVED
public class SubSetSumProblem {
	
	private int max;
	private int num[];
	
	/// UNSOLVED
	public SubSetSumProblem(int max, int num[]) {
		this.max = max;
		this.num = num;
	}
	
	/// UNSOLVED
	public List<List<Integer>> solve() {
		Arrays.sort(this.num);
		return solve(this.num, this.max, 0, new ArrayList<>(), new ArrayList<>());
	}
	
	/// UNSOLVED
	public List<List<Integer>> solve(int num[], int max, int start, List<List<Integer>> result, List<Integer> curr) {
		if(start >= num.length) {
			if(max == 0) {
				List<Integer> temp = new ArrayList<>();
				for(int in : curr) {
					temp.add(in);
				}
				curr.clear();
				result.add(temp);
				return result;
			}
		}
		for(int i = start; i < num.length; i++) {
			if(max != 0 && max > 0) {
				List<Integer> temp = new ArrayList<>();
				temp.addAll(curr);
				temp.add(num[i]);
				solve(num, max - num[i], i + 1, result, temp);
			}
		}
		return result;
	}

	/// UNSOLVED
	public static void main(String[] args) {
		int num[] = { 4, -2, 2, 3, 1 };
		int max = 5;
		SubSetSumProblem ssp = new SubSetSumProblem(max, num);
		List<List<Integer>> result = ssp.solve();
		System.out.println(result);
	}
}
