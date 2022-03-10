package com.a;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Serialization implements Cloneable {
	/**
	 * 
	 */
	// int age = 32;

	public static void main(String[] args)
			throws CloneNotSupportedException, InstantiationException, IllegalAccessException, ClassNotFoundException,
			IOException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Serialization cc = new Serialization();
		Serialization cc2 = (Serialization) cc.clone();
		// CloneClass cc3 = (CloneClass) Class.forName("CloneClass").newInstance();
		// Object
		// System.out.println(cc3.name);
		// System.out.println(cc.hashCode());
		// System.out.println(cc2.hashCode());
		// System.out.println(cc3.hashCode());
// ------------------------------------------------------------------------------------
		Student s = new Student();
		System.out.println("In serialize");
		FileOutputStream f = new FileOutputStream("file.txt");
		ObjectOutputStream oos = new ObjectOutputStream(f);
		oos.writeObject(s);
		oos.close();
		//System.out.println(s.name);

		// Freeing up memory resources
		f.close();
// -----------------------------------------------------------------------------------------
		// System.out.println(cc.equals(cc2));
		Constructor<Student> constructor = Student.class.getDeclaredConstructor();

		Student r = constructor.newInstance();
		// Custom passing
		//r.name = "GeeksForGeeks";
		// System.out.println(r.name);
	}
}
