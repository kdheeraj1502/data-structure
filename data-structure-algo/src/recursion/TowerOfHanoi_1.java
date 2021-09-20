package recursion;

public class TowerOfHanoi_1 {

	public static void towerOfHanoi(int num) {

		towerOfHanoi(num, 'A', 'C', 'B');
	}

	public static void towerOfHanoi(int num, char src, char des, char temp) {
		if(num == 0) return;
		System.out.println("Num is " + num + ": Src is : " + src + ", Temp is : " + temp + ", Des is : " + des);
		towerOfHanoi(num - 1, src, temp, des);
		System.out.println("Move " + num + " from " + src + " to " + des);
		towerOfHanoi(num - 1, temp, des, src);
		//System.out.println("Move " + num + " from " + src + " to " + des);
	}

	public static void main(String[] args) {
		int num = 4;
		towerOfHanoi(num);
	}
}
