package array;

public class BalancePoint {

	public static int balancePoint(int num[]) {
		int first = 0;
		int second = 0;
		for (int i = 0; i < num.length; i++) {
			second += num[i];
		}
		//45
		for (int i = 0; i < num.length; i++) {
			second -= num[i];
			if(first == second) {
				return i;
			}
			first += num[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		int num[] = { 7, 6, 5, 1, 2, 3, 4, 8, 9 };
		System.out.println(balancePoint(num));
	}
}
