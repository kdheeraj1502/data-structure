package dynamic.programming;

/**
 * O(n) time complexity
 * O(1)
 * 
 * @author dheerajkumar02
 *
 */
public class FrogJumpCountOptimize {

	public static int jump(int[] num) {
		int jumps = 0;
		int currEnd = 0;
		int currFarthest = 0;
		for (int i = 0; i < num.length - 1; i++) {
			currFarthest = Math.max(currFarthest, i + num[i]);
			if (i == currEnd) {
				jumps++;
				currEnd = currFarthest;
			}
		}

		// if jump is possible then below code is not require
		// It is only needed when jump might not be possible
		// < ---
		if (currEnd < num.length) {
			jumps = 0;
		}
		// --- >
		return jumps;
	}

	public static void main(String[] args) {

		int num[] = { 0, 0, 1, 1, 4 };

		System.out.println(jump(num));
	}
}
