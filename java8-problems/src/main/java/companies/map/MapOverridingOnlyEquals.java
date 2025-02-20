package companies.map;

import java.util.HashMap;
import java.util.Map;

public class MapOverridingOnlyEquals {
	
	class Key {
		
		private String val;


		@Override
		public int hashCode() {
			return 1;
		}


		@Override
		public boolean equals(Object obj) {
			return true;
		}


		@Override
		public String toString() {
			return "Key [val=" + val + "]";
		}

	}

	public static void main(String[] args) {
		MapOverridingOnlyEquals key = new MapOverridingOnlyEquals();
		Map<Key, String> map = new HashMap<>();
		map.put(key. new Key(), "One");
		map.put(key. new Key(), "Two");
		map.put(key. new Key(), "Three");
		
		System.out.println(map.size());
		
		System.out.println(map);
	}
}

