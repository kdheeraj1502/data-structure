package bin.packing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FirstFitDecreasingAlgoSelf {
	
	private List<Integer> items;
	private int binCapacity;
	private int binId = 1;
	private List<BinSelf> binsList;
	
	public FirstFitDecreasingAlgoSelf(List<Integer> items, int binCapacity) {
		this.items = items;
		this.binCapacity = binCapacity;
		
		this.binsList = new ArrayList<>(this.items.size());
	}
	
	public void solveBinPacking() {
		Collections.sort(this.items, Collections.reverseOrder());
		if(this.items.get(0) > this.binCapacity) {
			System.out.println("There is no solution..");
			return;
		}
		this.binsList.add(new BinSelf(binId, binCapacity));
		for(int curr : items) {
			boolean isOk = false;
			int currentBin = 0;
			while(!isOk) {
				if(currentBin == this.binsList.size()) {
					BinSelf bin = new BinSelf(++binId, binCapacity);
					bin.put(curr);
					this.binsList.add(bin);
					isOk = true;
				} else if(this.binsList.get(currentBin).put(curr)) {
					isOk = true;
				} else {
					currentBin++;
				}
			}
		}
	}
	
	public void showResult() {
		for(BinSelf bin : binsList) {
			System.out.println(bin);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> items = Arrays.asList(3, 2, 1, 4, 2);
		int binCapacity = 5;
		FirstFitDecreasingAlgoSelf ffda = new FirstFitDecreasingAlgoSelf(items, binCapacity);
		ffda.solveBinPacking();
		ffda.showResult();
	}
}
