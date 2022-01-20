package array;

import java.util.*;

// 
// [[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,0,2]
// [-2,-1,3],,[-1,-1,2],[-1,0,1]]
public class ThreeSum {
	static public List<List<Integer>> threeSum(int[] nums) {
		Map<Remain, Pair> map = new HashMap<>();
//-1,0,1,2,-1,-4,-2,-3,3,0,4
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				int x = 0 - sum;
				map.put(new Remain(x), new Pair(i, j, nums[i], nums[j]));
			}
		}
		Set<List<Integer>> result = new HashSet<>();
		for (int k = 0; k < nums.length; k++) {
			if (map.containsKey(new Remain(nums[k])) && map.get(new Remain(nums[k])).i != k && map.get(new Remain(nums[k])).j != k) {
				List<Integer> list = Arrays.asList(map.get(new Remain(nums[k])).val1, map.get(new Remain(nums[k])).val2, nums[k]);
				Collections.sort(list);
				result.add(list);
			}
		}
		return new ArrayList<>(result);
	}

	public static void main(String[] args) {
		int nums[] = { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };
		System.out.println(threeSum(nums));
	}
}

class Pair {
	public int i;
	public int j;
	public int val1;
	public int val2;

	Pair() {
	}

	Pair(int i, int j, int val1, int val2) {
		this.i = i;
		this.j = j;
		this.val1 = val1;
		this.val2 = val2;
	}
}

class Remain {
	public int val;

	Remain(int val) {
		this.val = val;
	}
	
	@Override
	public boolean equals(Object obj) {
		Remain r = (Remain) obj;
        return (this.val == r.val);
    }
	
	@Override
	public int hashCode() {
		return val;
	}
	
}
