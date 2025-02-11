package companies.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PlayingWithMap {

	public static void main(String[] args) {
		Map<Key, String> map = new HashMap<>();
		map.put(new Key(), "one");
		map.put(new Key(), "two");
		map.put(new Key(), "three");
		map.put(new Key(), "four");
		map.put(new Key(), "five");
		map.put(new Key(), "six");
		map.put(new Key(), "seven");
		map.put(new Key(), "eight");
		map.put(new Key(), "nine");
		map.put(new Key(), "ten");
		map.put(new Key(), "eleven");
		map.put(new Key(), "twelve");
		map.put(new Key(), "thirteen");
		map.put(new Key(), "fourteen");
		map.put(new Key(), "fifteen");
		map.put(new Key(), "sixteen");
		map.put(new Key(), "seventeen");
		map.put(new Key(), "eighteen");
		map.put(new Key(), "ninteen");
		map.put(new Key(), "twenty");
		map.put(new Key(), "twenty One");
		map.put(new Key(), "ten");
		map.put(new Key(), "eleven");
		map.put(new Key(), "twelve");
		map.put(new Key(), "thirteen");
		map.put(new Key(), "fourteen");
		map.put(new Key(), "fifteen");
		map.put(new Key(), "sixteen");
		map.put(new Key(), "seventeen");
		map.put(new Key(), "eighteen");
		map.put(new Key(), "ninteen");
		map.put(new Key(), "twenty");
		map.put(new Key(), "twenty One");
		map.put(new Key(), "ten");
		map.put(new Key(), "eleven");
		map.put(new Key(), "twelve");
		map.put(new Key(), "thirteen");
		map.put(new Key(), "fourteen");
		map.put(new Key(), "fifteen");
		map.put(new Key(), "sixteen");
		map.put(new Key(), "seventeen");
		map.put(new Key(), "eighteen");
		map.put(new Key(), "ninteen");
		map.put(new Key(), "twenty");
		map.put(new Key(), "twenty One");
		map.put(new Key(), "ten");
		map.put(new Key(), "eleven");
		map.put(new Key(), "twelve");
		map.put(new Key(), "thirteen");
		map.put(new Key(), "fourteen");
		map.put(new Key(), "fifteen");
		map.put(new Key(), "sixteen");
		map.put(new Key(), "seventeen");
		map.put(new Key(), "eighteen");
		map.put(new Key(), "ninteen");
		map.put(new Key(), "twenty");
		map.put(new Key(), "twenty One");
		map.put(new Key(), "ten");
		map.put(new Key(), "eleven");
		map.put(new Key(), "twelve");
		map.put(new Key(), "thirteen");
		map.put(new Key(), "fourteen");
		map.put(new Key(), "fifteen");
		map.put(new Key(), "sixteen");
		map.put(new Key(), "seventeen");
		map.put(new Key(), "eighteen");
		map.put(new Key(), "ninteen");
		map.put(new Key(), "twenty");
		map.put(new Key(), "twenty One");
	//	map.put(new Key(), "ten");
		System.out.println(map.size());
		System.out.println(map);

		int hash = "zzzzzzzzzz5877777777777777777777777777777zzzzzzzzzzz".hashCode();
		System.out.println(hash);
		int index = hash & 31;
		System.out.println(index);

		Map<Key, String> concurrent = new ConcurrentHashMap<>(map);
		concurrent.put(new Key(), "ten");

	}

}

class Key {

	String val;

	@Override
	public int hashCode() {
		return new Integer(7).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		String anotherString = "";
		if (obj instanceof String) {
			anotherString = (String) obj;
		}
	//	return anotherString.equals(val);
		return true;
	}
}
