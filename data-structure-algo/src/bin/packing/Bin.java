package bin.packing;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * It contains id, capacity, current size, and collection of items
 * @author dheerajkumar02
 *
 */
public class Bin {

	private int binId;
    private int capacity;
    private int currentSize;
    private List<Integer> items;

    public Bin(int capacity, int binId) {
        this.capacity = capacity;
        this.binId = binId;
        this.items = new ArrayList<Integer>();
    }

    public boolean put(Integer item) {
    	
    	if( this.currentSize + item > this.capacity ) return false;
    	
        this.items.add(item);
        this.currentSize += item;
            
        return true;
    }
    
    @Override
    public String toString() {
     
    	String contentOfBin = "Items in bin #"+this.binId+": ";
    	
    	for(Integer item : this.items){
    		contentOfBin += item+" ";
    	}
    	
    	return contentOfBin;
    }
}
