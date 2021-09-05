package sorting.problem;

import range.partition.Main;

public class Partition01And2 {

	public static void partition(int num[]) {
		
		int a = 0;
		int b = num.length - 1;
		int i = 0;
		
		while(i <= b) {
			if(num[i] == 0) {
				Main.swap(num, i, a);
				i++;
				a++;
			}
			else if(num[i] == 2) {
				Main.swap(num, i, b);
				b--;
			}
			else
				i++;
		}
		
	}
	
	public static void partitionSelf(int num[]) {
		
		int a = 0;
		int b = num.length - 1;
		int i = 0;
		while(i <= b) {
			
			if(num[i] == 0) {
				Main.swap(num, i, a);
				i++;a++;
			}
			else if(num[i] == 2) {
				Main.swap(num, i, b);
				b--;
			}
			else
				i++;
		}
	}
}
