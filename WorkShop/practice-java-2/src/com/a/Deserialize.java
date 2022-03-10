package com.a;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Deserialize {

	public static void main(String[] args) throws Exception {
		FileInputStream f1 = new FileInputStream("D:\\personal project data_1\\data-structure\\WorkShop\\practice-java\\file.txt");

		// Creating ObjectInputStream class object
		ObjectInputStream oos = new ObjectInputStream(f1);
		Student s = (Student) oos.readObject();
		System.out.println("In deserialize");
		System.out.println(s.name);
		oos.close();
	}
}

//D:\personal project data_1\data-structure\WorkShop\practice-java\file.txt

class CloneClass implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 38806869021L;
	public String name = "CloneClass";
	
}