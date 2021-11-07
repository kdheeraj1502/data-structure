package searching;

public class DuplicateElement {
	
	public static int findRepeating(int num[]) {
		boolean aux[] = new boolean[num.length];
		int result = -1;
		for(int i = 0; i < num.length; i++) {
			if(aux[num[i]]) {
				result = num[i];
			} else {
				aux[num[i]] = true;
			}
		}
		return result;
	}

	public static void printRepeating(int num[]) {
		int range = 100;
		int count[] = new int[range];
		for (int i = 0; i < num.length; i++) {
			count[i] = 0;
		}
		System.out.println(" Repeating elements are ");
		for (int i = 0; i < num.length; i++) {
			if (count[num[i]] == 1) {
				System.out.println(" " + num[i]);
			} else {
				count[num[i]]++;
			}
		}
	}
}
