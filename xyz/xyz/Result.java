package xyz;

import java.util.*;

public class Result {

	// 1 3 2 3 4 1
	// 000101
	// 110000

	public static List<String> bitPattern(List<Integer> num) {
		Map<Integer, Integer> count = new HashMap<>();
		Map<Integer, List<Integer>> pos = new HashMap<>();
		List<Integer> posList = null;
		List<String> result = new ArrayList<>();
		for (int i = 0; i < num.size(); i++) {
			count.put(num.get(i), count.getOrDefault(num.get(i), 0) + 1);
			posList = pos.get(num.get(i)) != null ? pos.get(num.get(i)) : new ArrayList<>();
			posList.add(i);
			pos.put(num.get(i), posList);
		}

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < num.size(); i++) {
			sb1.append(0);
			sb2.append(0);
		}

		HashSet<Integer> nums = new HashSet<>(num);
		for (Integer n : nums) {
			if (count.get(n) > 1) {
				List<Integer> list = pos.get(n);
				sb1.setCharAt(list.get(0), '0');
				for (int j = 1; j < list.size(); j++) {
					int p = list.get(j);
					sb1.setCharAt(p, '1');
				}
			} else {
				List<Integer> list = pos.get(n);
				for (int j = 0; j < list.size(); j++) {
					int p = list.get(j);
					sb1.setCharAt(p, '0');
				}

			}
		}

		for (Integer n : nums) {
			if (count.get(n) > 1) {
				List<Integer> list = pos.get(n);
				sb2.setCharAt(list.get(0), '1');
				for (int j = 1; j < list.size(); j++) {
					int p = list.get(j);
					sb2.setCharAt(p, '0');
				}

			} else {
				List<Integer> list = pos.get(n);
				for (int j = 0; j < list.size(); j++) {
					int p = list.get(j);
					sb2.setCharAt(p, '0');
				}

			}
		}
		result.add(sb1.toString());
		result.add(sb2.toString());
		return result;
	}
	/*
	 * public static void main(String[] args) {
	 * 
	 * List<Integer> num = Arrays.asList(1, 3, 2, 3, 4, 1); List<String> result =
	 * bitPattern(num); System.out.println(result);
	 * 
	 * 
	 * 
	 * try { int x = 0; for (x=1; x<4; x++); System.out.println(x); }
	 * catch(Exception e) {} finally { System.out.println("Error"); }
	 * 
	 * }
	 */
	public static void main(String[] args) { 
		
		 Map<Integer, String> m = new TreeMap<Integer,String>();
		 m.put(11, "audi");
	        m.put(null, null);
	        m.put(11, "bmw");
	        m.put(null, "fer");

	        System.out.println(m.size());
		
		
	     try { 
	             System.out.println(doStuff(args)); 
	         } 
	         catch (Exception e) { System.out.println("exc"); } 
	         doStuff(args); 
	     }
	     static int doStuff(String[] args) { 
	         return Integer.parseInt(args[0]); 
	     }
}
