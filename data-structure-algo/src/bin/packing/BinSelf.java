package bin.packing;

import java.util.*;

public class BinSelf {

	private int binId;
	private int capacity;
	private int size;
	private List<Integer> items;
	
	public BinSelf(int binId, int capacity) {
		this.binId = binId;
		this.capacity = capacity;
		this.items = new ArrayList<>();
	}
	
	public boolean put(Integer currentItem) {
		if(this.size + currentItem > this.capacity) return false;
		this.items.add(currentItem);
		this.size += currentItem;
		return true;
	}

	@Override
	public String toString() {
		String contentOfBin = "Items in bin #" + this.binId + " : ";
		for(int item : items) {
			contentOfBin += item + " ";
		}
		return contentOfBin;
	}
}
