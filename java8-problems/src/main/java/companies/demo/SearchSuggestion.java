package companies.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchSuggestion {

	public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
		List<List<String>> res = new ArrayList<>();
		
		for (int i = 1; i < customerQuery.length(); i++) {
			String s = customerQuery.substring(0, i + 1).toLowerCase();
			List<String> temp = new ArrayList<>();
			int a = 0;
			for (int j = 0; j < repository.size(); j++) {
				if (repository.get(j).toLowerCase().startsWith(s)) {
					temp.add(repository.get(j).toLowerCase());
					a++;
				}
			}
			Collections.sort(temp);
			List<String> v = new ArrayList<>();
			for (int p = 0; p <= 2 && p < temp.size(); p++) {
				v.add(temp.get(p));
			}
			res.add(v);
		}
		return res;
	}
	
	public static void main(String[] args) {
		String str = "dheeraj";
		List<String> res = Arrays.asList("Dharmendra", "Dheeraj", "Dhuthag", "Dhkuail", "Dhtyupao");
//		bags
//		baggage
//		banner
//		box
//		cloths
//		bags
		System.out.println(searchSuggestions(res, str));
	}
}
