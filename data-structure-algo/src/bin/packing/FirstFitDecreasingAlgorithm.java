package bin.packing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FirstFitDecreasingAlgorithm {

	private List<Bin> binsList;
	
	private List<Integer> items;
	private int binCapacity;
	private int binId = 1;

    public FirstFitDecreasingAlgorithm(List<Integer> items, int binCapacity) {
    	
        this.items = items;
        
        this.binCapacity = binCapacity;
        
        // bin bag for storing items
        // Size is same as input items list
        this.binsList = new ArrayList<>(this.items.size());
    }

    public void solveBinPackingProblem() {
       
    	// Sorting the input items list in reverse/decreasing order
    	Collections.sort(this.items, Collections.reverseOrder());
    
    	// Check if input 1st item is larger then bin capacity or max bin accepatable size
    	// if 1st item is bigger than whole capacity then no need to check for other items
    	if( this.items.get(0) > this.binCapacity ){
    		System.out.println("No feasible solution...");
    		return;
    	}
    	
    	// Adding Bin object bcz item size is lower or equivalent than bin capacity
    	// Having Id 1 into Bin type Arraylist
    	this.binsList.add(new Bin(binCapacity,binId));  // first bin !!!
        
    	// Using for each on item to insert it in Bin Array list after setting Bin Object param
    	for (Integer currentItem : items) {
           //[4, 3, 2, 2, 1]
            boolean isOk = false; // track whether we have kept the item into a bin or not
            int currentBin = 0;
            
            while (!isOk) {
                if (currentBin == this.binsList.size()) {  // item does not fit in last bin -> try a new bin
                    Bin newBin = new Bin(binCapacity,++binId);
                    newBin.put(currentItem);
                    this.binsList.add(newBin);
                    isOk = true;
                } else if (this.binsList.get(currentBin).put(currentItem)) {  // current item fits in the given bin
                    isOk = true;
                } else {                
                    currentBin++;  // trying the next bin
                }
            }
        }
    }
    
    public void showResults(){
    	for(Bin bin : this.binsList){
    		System.out.println(bin);
    	}
    }
	public static void main(String[] args) {

		List<Integer> items = Arrays.asList(3, 2, 1, 4, 2);
		int binCapacity = 5;

		FirstFitDecreasingAlgorithm algorithm = new FirstFitDecreasingAlgorithm(items, binCapacity);
		algorithm.solveBinPackingProblem();
		algorithm.showResults();

	}
}
