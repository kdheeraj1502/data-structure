package faang.interview.problems;

/**
 * Find the amount of water in container
 * array if height of container
 * height space is not involve
 * in between height space is also not involve
 * 
 * 
 * @author dheerajkumar02
 *
 */
public class WaterContainer {

	// Two pointer left and right
	// increase left index val if its height is smaller than right height
	// else decrease right index val
	public int maxArea(int []height) {
		int left = 0;
		int right = height.length - 1;
		int currArea = 0;
		int maxArea = 0;
		int leftHeight = 0;
		int rightHeight = 0;
		while(left < right) {
			leftHeight = height[left];
			rightHeight = height[right];
			currArea = Math.min(leftHeight, rightHeight) * (right - left);
			maxArea = Math.max(maxArea, currArea);
			if(leftHeight > rightHeight) right--;
			else left++;
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		int height[] = {1,8,6,2,5,4,8,3,7};
		WaterContainer wc = new WaterContainer();
		System.out.println(wc.maxArea(height));
	}
}
