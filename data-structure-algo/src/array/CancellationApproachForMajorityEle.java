package array;

public class CancellationApproachForMajorityEle {

	public static void findMajority(int num[]) {
		int count = 1;
		int majIndex = 0;
		int candidate;
		for (int i = 1; i < num.length; i++) {
			int a = num[majIndex];
			if (num[majIndex] == num[i])
				count++;
			else
				count--;
			if (count == 0) {
				majIndex = i;
				count = 1;
			}
		}
		candidate = num[majIndex];
		count = 0;
		for (int i = 0; i < num.length; i++) {
			if (candidate == num[i])
				count++;
		}

		if (count > num.length/2) {
			System.out.println("Majority is : " + num[majIndex]);
		} else
			System.out.println("Majority not found, count is :" + count);
	}

	public static void main(String[] args) {
		int num[] = {  5, 3, 5, 2, 5, 5, 3, 5, 8 };
		findMajority(num);
	}
}
