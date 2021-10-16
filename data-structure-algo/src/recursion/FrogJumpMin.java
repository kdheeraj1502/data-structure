package recursion;

public class FrogJumpMin {

	private int num[];

	public FrogJumpMin(int num[]) {
		this.num = num;
	}

	public int minJumps(int start, int end) {
		if (start >= end)
			return 0;
		 if (num[start] == 0)
	            return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= num[start] && i <= end; i++) {
			int jumps = 1 + minJumps(start + i, end);
			if (jumps < min)
				min = jumps;
		}	
		return min;
	}

	public static void main(String[] args) {
		int num[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		FrogJumpMin fjm = new FrogJumpMin(num);
		System.out.print("Minimum number of jumps to reach end is " + fjm.minJumps(0, num.length - 1));
	}
}
