package dynamic.programming;

public class FrogJumpMin {

	public int minJump(int num[]) {
		int jumps[] = new int[num.length];
		jumps[0] = 0;
		for (int i = 1; i < jumps.length; i++)
			jumps[i] = Integer.MAX_VALUE;

		for (int i = 1; i < num.length; i++) {
			for (int j = 0; j < i; j++) {
				if (i <= j + num[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
				}
			}
		}
		return jumps[jumps.length - 1];
	}

	public static void main(String[] args) {
		int num[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		FrogJumpMin fjm = new FrogJumpMin();
		System.out.print("Minimum number of jumps to reach end is " + fjm.minJump(num));
	}
}
