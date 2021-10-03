package bit.masking;

public class SquareOfTheNumber {

	public static int square(int num) {
		if (num == 0)
			return 0;
		if (num == 1)
			return 1;
		int square;
		if ((num & 1) != 1) {
			int a = (square(num / 2) << 2);
			square = a;
		} else {
			int a = (square(num / 2) << 2) + ((num / 2) << 2) + 1;
			square = a;
		}
		return square;
	}

	public static void main(String[] args) {
		System.out.println(square(10));
	}
}
