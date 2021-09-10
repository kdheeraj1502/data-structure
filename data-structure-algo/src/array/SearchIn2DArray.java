package array;

public class SearchIn2DArray {
	
	public static boolean findElein2D(int num[][], int key) {
		int val = num[0][num[0].length - 1];
		int row = 0;
		int column = num[row].length - 1;;
		while(row >= 0 && row < num.length && column >= 0 && column < num[row].length) {
			if(key == val)
				return true;
			if(key < val) {
				column--;
				val = num[0][column];
			}
			if(key > val) {
				row++;
				val = num[row][column];
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int num[][] = { 
						{1, 2, 3, 4, 5}, 
						{2, 3, 4, 5, 6}, 
						{3, 4, 5, 6, 7} 
					};
		
		for(int[] in : num) {
			for(Integer i : in) {
				System.out.println(findElein2D(num, i));
			}
		}
	}
}
