package com.stream;

import java.io.IOException;

public class ClassException extends Parent implements interface1, interface2 {

	public void method() throws IOException {
		System.out.println("child");
	}

	public static void main(String[] args) throws IOException {
		Parent p = new ClassException();
		ClassException i1 = new ClassException();
		p.method();
		i1.method1();
		i1.write();
	}

	@Override
	public void method1() {
		System.out.println("In method1");
	}

	@Override
	public void write() {
		interface1.super.write();
		interface1.super.write();
	}
}

class Parent {
	public void method() throws ArithmeticException, IOException{
		System.out.println("parent");
	}
}

interface interface1 {
	int num = 111;

	void method1();

	default void write() {
		System.out.println("interface1 default method");
	}
}

interface interface2 {
	int num = 222;

	void method1();

	default void write() {
		System.out.println("interface2 default method");
	}
}