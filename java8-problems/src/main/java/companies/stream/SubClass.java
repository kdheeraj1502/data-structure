package companies.stream;

import java.util.Collections;

public class SubClass extends PrivateConstructorAbstract {

	public void method(String str) {

	}

	public void method(Integer str) {

	}

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "ab";
		String s3 = s2 + "c";

		System.out.println(s1.hashCode());
		System.out.println(s1 == s3);
		System.out.println(s2.hashCode() + " " + "c".hashCode());
		System.out.println(s3.hashCode());
		
		SubClass sc = new SubClass();
	//	sc.method(null);
		Thread.yield();
		Collections.sort(null);
	}
}
