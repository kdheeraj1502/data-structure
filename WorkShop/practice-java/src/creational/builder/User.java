package creational.builder;

import java.util.concurrent.ConcurrentLinkedQueue;

public class User {

	private final String firstName;
	private final String lastName;
	private final int age;
	private final String phone;
	private final String address;

	private User(UserBuilder userBuilder) {
		this.firstName = userBuilder.firstName;
		this.lastName = userBuilder.lastName;
		this.age = userBuilder.age;
		this.phone = userBuilder.phone;
		this.address = userBuilder.address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", phone=" + phone
				+ ", address=" + address + "]";
	}

	public static class UserBuilder {
		private String firstName;
		private String lastName;
		private int age;
		private String phone;
		private String address;

		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		UserBuilder(){}

		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}

		public User build() {
			User user = new User(this);
			someValidation(user);
			return user;
		}

		private void someValidation(User user) {

		}
	}
	
	public static void main(String[] args) {
		User user = new User.UserBuilder().age(13).phone(new String("1234567")).build();
		
		System.out.println(user.age);
		
	//	ConcurrentLinkedQueue<E>
	}
}
