package bin.packing;

import java.util.*;


//  SORTED ARRAY IS INORDER FORM OF BST
public class MinimumSwapToConvertBinaryTreeInToBST {

	static void inorder(int num[], Vector<Integer> v, int n, int index) {
		if (index < n) {
			inorder(num, v, n, 2 * index + 1);
			v.add(num[index]);
			inorder(num, v, n, 2 * index + 2);
		}
	}

	public static int minSwaps(Vector<Integer> arr) {
		List<Pair> nums = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			nums.add(new Pair(arr.get(i), i));
		}

		nums.sort(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {

				return o1.first - o2.first;
			}

		});
		int swap = 0;
		for(int i = 0; i < nums.size(); i++) {
			if(nums.get(i).second == i) continue;
			else {
				swap++;
				int index = nums.get(i).second;
				Pair temp = nums.get(index);
				nums.set(index, nums.get(i));
				nums.set(i, temp);
			}
		}
		
		/*
		 * Boolean[] vis = new Boolean[arr.size()]; Arrays.fill(vis, false); int ans =
		 * 0; for (int i = 0; i < nums.size(); i++) { if (vis[i] || nums.get(i).first ==
		 * i) { continue; } int cycle_size = 0; int j = i; while (!vis[j]) { vis[j] =
		 * true; j = nums.get(j).second; cycle_size++; } if (cycle_size > 0) { ans +=
		 * (cycle_size - 1); } }
		 */
		return swap;
	}

	public static void main(String[] args) {
		int a[] = { 5, 6, 7, 8, 9, 10, 11 };
		Vector<Integer> v = new Vector<>();
		inorder(a, v, a.length, 0);
		System.out.println(minSwaps(v));
	}
}

class Pair {
	int first, second;

	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}
	
}