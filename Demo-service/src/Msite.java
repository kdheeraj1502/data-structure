
public enum Msite {

	NO(0), YES(1);

	private final int value;

	Msite(final int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}
}
