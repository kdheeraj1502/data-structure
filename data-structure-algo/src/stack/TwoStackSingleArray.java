package stack;

public class TwoStackSingleArray {

	private int top1;
	private int top2;

	private int maxCapacity = 10;
	private int elementData[];

	TwoStackSingleArray() {
		top1 = -1;
		top2 = maxCapacity;
		elementData = new int[maxCapacity];
	}

	TwoStackSingleArray(int maxCapacity) {
		top1 = -1;
		top2 = maxCapacity - 1;
		this.maxCapacity = maxCapacity;
		elementData = new int[maxCapacity];
	}

	public void stackPush(int val, int stack) {
		if (top1 < top2 - 1) {
			if (stack == 0) {
				elementData[++top1] = val;
			} else if (stack == 1) {
				elementData[--top2] = val;
			}
		} else {
			System.out.println("Stack is full");
		}
	}

	public int stackPop1() {
		if (top1 >= 0) {
			int val = elementData[top1--];
			return val;
		} else {
			System.out.println("Stack is empty");
		}
		return Integer.MIN_VALUE;
	}

	public int stackPop2() {
		if (top2 < maxCapacity) {
			int val = elementData[top2++];
			return val;
		} else {
			System.out.println("Stack is empty");
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		TwoStackSingleArray tsa = new TwoStackSingleArray();
		for (int i = 18; i < 30; i++) {
			tsa.stackPush(i, i % 2);
		}
		int max = tsa.top1;
		for (int i = 0; i < tsa.top2; i++) {
			System.out.println(tsa.stackPop1());
		}
		for (int i = tsa.maxCapacity - 1; i > max; i--) {
			System.out.println(tsa.stackPop2());
		}
	}
}
