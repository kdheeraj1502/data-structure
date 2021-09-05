package searching;

import java.util.*;

public class FindMissingNumberUseSet {

	public static int findMissingNumberSet(int num[]) {
		Set<Integer> set = new HashSet<>();
		for(Integer in : num) {
			set.add(in);
		}
		int i = 1;
		
		while(i < set.size()) {
			if(set.contains(i) == false) {
				return i;
			}
			i++;
		}
		return -1;
	}
}
