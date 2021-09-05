package sorting;

public class MergeArray {

	public static void merge(int num1[], int num2[]) {
		int index = 0;
		while(index < num1.length) {
			if(num1[index] <= num2[0]) {
				index += 1;
			}else {
				num1[index] ^= num2[0] ^= num1[index] ^= num2[0];
				index += 1;
				for(int i = 0; i < (num2.length - 1); i++) {
					if(num2[i] < num2[i + 1])
						break;
					num2[i] ^= num2[i + 1] ^= num2[i] ^= num2[i + 1];
				}
			}
		}
	}
}
