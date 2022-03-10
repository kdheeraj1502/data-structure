package xyz;

import java.util.*;

public class Larger {

	public static List<Integer> larger(int arr[]) {
		List<Integer> result = new ArrayList<>();
		int index = 0;
		int j = 0;
		result.add(Integer.MIN_VALUE);
		for(int i = arr.length - 1; i >= 0; i--){
			if(result.get(index) < arr[i]){
		  	result.add(j, arr[i]);
		    j++;
		    index = j - 1;
		  }
		}
		result.remove(result.size() - 1);
		return result;
	}
	
	public static void main(String[] args) {
		int nums[] = {16, 17, 4, 3, 5, 2};
		System.out.println(larger(nums));
	}
}
