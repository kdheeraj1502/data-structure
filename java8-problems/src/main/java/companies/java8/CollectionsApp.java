package companies.java8;

import java.util.*;

public class CollectionsApp {

	public static void main(String[] args) {

		Key key1 = new Key();
		Key key2 = new Key();
		key1.setId(100);
		key1.setName("hundred");
		Map<Key, String> map = Collections.singletonMap(key1, "key1");
//		map.put(key2, "key2");
		System.out.println(map + " And hash code is : " + key1.hashCode());
		for (Map.Entry<Key, String> entry : map.entrySet()) {
			entry.getKey().setId(1000);
			entry.getKey().setName("thousand");
		}
		System.out.println(map + " And hash code is : " + key1.hashCode());
		
		List<Key> list = Collections.singletonList(key1);
		System.out.println(list);
		// list.add(key1);

		Set<Key> single = Collections.singleton(key1);
		System.out.println(single + " And hash code is : " + key1.hashCode());

		List<Key> list1 = new ArrayList<>();

		// populate the list
		list1.add(key1);
		list1.add(key2);

		// printing the list
		System.out.println("Initial list: " + list);

		// getting unmodifiable list
		// using unmodifiableList() method
		List<Key> immutablelist = Collections.unmodifiableList(list1);
		System.out.println(immutablelist);
		
		immutablelist.get(0).setName("million");
		
		System.out.println(immutablelist);
		
	//	immutablelist.remove(key2);
	//	immutablelist.add(key2);
		
		
		System.out.println("Unmodifiable list: " + immutablelist);
		
		LinkedHashSet<Integer> link = new LinkedHashSet<>();
		link.add(67);
		link.add(45);
		link.add(91);
		link.add(57);
		
		Map<Integer, String> tree = new TreeMap<>();
		//tree.put(null, "null");
		tree.put(2, "Two");
		tree.put(2, "new two");
		System.out.println(tree);
		System.out.println(tree.size());

	}
}

class Key {

	int id;
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Key [id=" + id + ", name=" + name + "]";
	}

}