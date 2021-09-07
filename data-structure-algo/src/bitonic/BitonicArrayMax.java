package bitonic;

public class BitonicArrayMax {

	public static int bitonicArrayMax(int num[]) {
		int start = 0;
		int end = num.length - 1;
		int mid = (start + end) / 2;
		int maximaFound = 0;
		if (num.length < 3) {
			System.out.println("error");
			return 0;
		}
		while (start <= end) {
			mid = (start + end) / 2;
			if (num[mid - 1] < num[mid] && num[mid] > num[mid + 1]) {
				maximaFound = 1;
				break;
			} else if (num[mid - 1] < num[mid] && num[mid] < num[mid + 1]) {
				start = mid + 1;
			} else if (num[mid - 1] > num[mid] && num[mid + 1] < num[mid]) {
				end = mid - 1;
			} else
				break;
		}
		if (maximaFound == 0) {
			System.out.println("error");
			return 0;
		}
		return num[mid];
	}

	public static void main(String args[]) {
		int num[] = { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };
//		System.out.println(bitonicArrayMax(num));
		System.out.println(bitonicArrayMaxSelf(num));
	}

	public static int bitonicArrayMaxSelf(int num[]) {
		int start = 0;
		int end = num.length - 1;
		int maxFound = 0;
		int mid = (start + end) / 2;
		while (start <= end) {
			mid = (start + end) / 2;
			if ((num[mid] > num[mid - 1]) && num[mid] > num[mid + 1]) {
				maxFound = 1;
				break;
			} else if ((num[mid] < num[mid + 1]) && (num[mid] > num[mid - 1])) {
				start = mid + 1;
			} else if ((num[mid] < num[mid - 1]) && num[mid] > num[mid + 1]) {
				end = mid - 1;
			} else
				break;
		}
		if (maxFound == 1)
			return num[mid];
		else {
			return 0;
		}

	}
}
