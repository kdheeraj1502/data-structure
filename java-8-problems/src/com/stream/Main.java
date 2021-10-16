package com.stream;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		List<Integer> list = CollectEvenNumber.evenNum(myList);
		list.forEach(System.out::println);
	}
}
