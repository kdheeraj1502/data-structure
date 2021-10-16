package backtracking;

//
// NOT Solved
//
public class FrogJumpMin {

	private int jumps[][];
	private int elements[];
	private int min;
	private int result;

	public FrogJumpMin(int elements[]) {
		this.elements = elements;
		this.min = Integer.MAX_VALUE;
		this.result = 0;
	}
	
	public void solve() {
		minJump(0);
	}

	private boolean minJump(int index) {
		if(elements.length <= index) {
			return true;
		}
		for(int i = 0; i < elements.length; i++) {
			if(isValid(index)) {
				if(min >= result) {
					result = result + 1;
					min = result;
					for(int j = 0; j < elements[i]; j++) {
						if(minJump(elements[i] + i - j)) {
							return true;
						}
						result = result - 1;
					}
				}
			}
			return false;
		}
		return false;
	}
	
	public boolean isValid(int index) {
		if(index >= elements.length || elements[index] == 0)
			return false;
		return true;
	}

	public static void main(String[] args) {
		int num[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		
		FrogJumpMin fjm = new FrogJumpMin(num);
		fjm.solve();
		System.out.println(fjm.result);
	}
}
