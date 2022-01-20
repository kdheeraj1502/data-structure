package serialization;

import java.io.*;

public class Demo {
	public static void main(String... args) throws Exception, IOException {
		File f = new File("Test.txt");
		User u1 = new User("JavaTpoint", 25);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(u1);
		System.out.println(u1.hashCode());
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		u1 = (User) in.readObject();
		System.out.println("After De externalization username: " + u1.getUserName() +
				" and age is:" + u1.getAge());

		System.out.println(u1.hashCode());
	}
}

class User implements Serializable {
	private String name;
	private int age;

	public User() {
	}

	public User(String userName, int age) {
		this.name = userName;
		this.age = age;
	}

	// @Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		age = in.readInt();
	}

	private Object readResolve() {
		return this;
	}

	// @Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
	}

	public String getUserName() {
		return name;
	}

	public void setUserName(String userName) {
		this.name = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}