package dynamic.programming;

import java.util.LinkedList;
import java.util.Queue;

// Input array is jumps values
// We have to reach at last index
public class FrogJumpBFS {

	public static int jump(int[] num) {
		// To check if the input array index has been visited or not
		// visited means we have jumped and reached on this index
		boolean visited[] = new boolean[num.length];
		// In breadth first search we use queue to run in layers, 
		// In depth first search we use stack to reach at bottom
		Queue<Node> queue = new LinkedList<>();
		// Start Node object with index 0 and distance 0
		queue.add(new Node(0, 0));
		// Set visted at 0 index as true
		visited[0] = true;
		// Check is queue is not empty and we will perform BFS using queue
		while (!queue.isEmpty()) {
		//	Node temp = queue.peek();
			// tale Node object out from queue to find the index and the distance
			Node temp = queue.poll();
			// We will take node from queue and run the inner loop 
			// upto the the jumps count we got from 0 index
			// for example if its 1 then only 1 time loop if its 2 then 2 times loop
			// in each loop we add the new node object with distance + 1 and index is loop count
			// Through this way we can achieve minimum jump
			// bcz we storing distance for each index for each value of jump
			
			
			// loop will start from Node index start value which is 0
			// Loop wil go upto min of (array length or input array [0] value + next index) 
			// which ever is lower because i must not go beyond the input array
			// or i must not go beyond input array jumps count
			// We have to jump upto the length of input array using input array values of jumps
			
			// start loop from 1
			for (int i = temp.index + 1; i < Math.min(num.length, temp.index + num[temp.index] + 1); i++) {
				// if i index is not visited then only use this index
				if (!visited[i]) {
					
					// If its last index then return distance store in last index
					// we stored distance on each index
					if (i == num.length - 1) {
						return temp.dist + 1;
					}
					// if not visted then store the next index starting from 0 
					// and the distance added with 1 bcz on next index we will consume 1 step 
					// hence the distance will increase by 1
					queue.add(new Node(i, temp.dist + 1));
					// mark visited for the index
					visited[i] = true;
				}
			}
		}
		return 0;
	}
	
    public int jump_1(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int farthest = 0;
        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);
            if(i == currEnd){
                jumps++;
                currEnd = farthest;
            }
        }
        return jumps;
    }

	public static void main(String[] args) {
		int num[] = { 2, 3, 1, 1, 4 };
		System.out.println(jump(num));
	}
	
	
}

// Node object it store the index starting from 0 
// and distance starting from 0
class Node {
	int index;
	int dist;

	Node(int index, int dist) {
		this.index = index;
		this.dist = dist;
	}
}