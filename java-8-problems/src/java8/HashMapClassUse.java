package java8;

import java.util.*;

public class HashMapClassUse {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < 10000; i++) {
			map.put(i, i);
		}
		System.out.println(map.size());
	}
}
