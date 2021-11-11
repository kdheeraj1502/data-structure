package design.monarchy;

import java.util.List;

public interface Monarchy {

	public void birth(String childName, String parentName);
	public void death(String name);
	public List<String> getOrderOfSuccession();
}
