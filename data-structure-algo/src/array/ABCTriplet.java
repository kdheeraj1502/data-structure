package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Find triplate
 * 
 * A + B = C
 * 
 * 1. SORT THE ARRAY
 * 2. RUN FOR LOOP i STARTING FROM LAST INDEX 
 * 3. TAKE VARIABLE START = 0;
 * 4. TAKE VARIABLE END = i - 1;
 * 5. ADD INNER WHILE LOOP WHERE START IS SMALLER THAN END
 * 			USING BINARY SEARCH
 * 6. ADD START VAL AND END VAL AND EQUAL WITH i VAL
 * 
 * 
 * @author dheerajkumar02
 *
 */
public class ABCTriplet {
	
	public static void findTriplet(int num[]) {
		// 1. 
		Arrays.sort(num);
		for (int i = num.length - 1; i >= 0; i--) {
	//	for(int i = 2; i < num.length; i++) {
			int j = 0;
			int k = i - 1;
			int a = num[i];
			//[-5, -4, 0, 1, 2, 3, 5, 7, 8, 12]
			while (j < k) {
				int b = num[j];
				int c = num[k];
				int sum = b + c;
				if (num[i] == sum) {
					System.out.println("numbers are " + num[i] + " = " + num[j] + " + " + num[k]);
					j++;
					k--;
				//	return;
				} else if (num[i] > sum)
					j += 1;
				else
					k -= 1;
			}
		}
	}
	
	public static void main(String[] args) {
	//	int num[] = { 5, 32, 1, 7, 10, 50, 19, 21, 2 };
		int num[] = { 2, 7, 3, 5, -5, 8, -4, 1, 0, 12 };
		List<List<Integer>> result = new ArrayList<>();
	//	System.out.println(abcTriplet(num, result));
		System.out.println("-----Found triplet--------");
		findTriplet(num);
		//numberSumBook(num);
		System.out.println("-----Found triplet self--------");
		findTriplet_self(num);
		System.out.println("-----Found triplet similar to self--------");
		findTriplets(num, num.length);
	}
	
	public static List<List<Integer>> abcTriplet(int num[], List<List<Integer>> output) {
		Arrays.sort(num);
		int start;
		int end;
		
		int result[] = new int[3];
		for (int i = 0; i < num.length - 2; i++) {
			start = i + 1;
			end = num.length - 1;
			// [-5, -4, 0, 1, 2, 3, 5, 7, 8, 12]
			int a = num[i];
			while (start < end) {
				int b = num[start];
				int c = num[end];
				int sum = b + c;
				// System.out.println("num[i] is " + num[i] + " sum of " + num[start] + " and "
				// + num[end] + " is " + sum);
				if (a == sum) {
					result[0] = num[start];
					result[1] = num[i];
					result[2] = num[end];
					List<Integer> list = new ArrayList<>();
					list.add(num[start]);
					list.add(num[end]);
					list.add(num[i]);
					output.add(list);
					start++;
					end--;
				} else if (a > sum)
					start++;
				else
					end--;
			}
		}
		return output;
	}

	public static void numberSumBook(int num[]) {
		int start, stop;
		// Arrays.sort(num);
		for (int i = 0; i < (num.length); i++) {
			start = i + 1;
			stop = num.length - 1;
			System.out.println("hi");
			while (start < stop) {
				if (num[i] == num[start] + num[stop]) {
					System.out.println("hello");
					System.out.println("Triplet ::%d, %d, %d" + num[i] + num[start + num[stop]]);
					start += 1;
					stop -= 1;
				} else if (num[i] > num[start] + num[stop])
					stop -= 1;
				else
					start += 1;
			}
		}
	}

	public static void findTriplet_self(int num[]) {
		Arrays.sort(num);
		// for (int i = n - 1; i >= 0; i--) {
		for (int i = num.length - 1; i >= 0; i--) {
			int start = 0;
			int end = i - 1;
			int c = num[i];
			while (start < end) {
				int a = num[start];
				int b = num[end];
				int sum = a + b;
				if (sum == c) {
					// pair found
					System.out.println("numbers are " + Math.abs(c) + " = " + a + " + " + b);
					start++;
					end--;
					//return;
				} else if (sum > c)
					end--;
				else
					start++;
			}
		}

		// no such triplet is found in array
		//System.out.println("No such triplet exists");
	}
	
		public static void findTriplets(int arr[], int n)
		{
		    boolean found = false;
		 
		    // sort array elements
		    Arrays.sort(arr);
		 
		    for (int i=0; i<n-1; i++)
		    {
		        // initialize left and right
		        int l = i + 1;
		        int r = n - 1;
		        int x = arr[i];
		        while (l < r)
		        {
		            if (x + arr[l] + arr[r] == 0)
		            {
		                // print elements if it's sum is zero
		                    System.out.print(x + " ");
		                    System.out.print(arr[l]+ " ");
		                    System.out.println(arr[r]+ " ");
		     
		                l++;
		                r--;
		                found = true;
		            }
		 
		            // If sum of three elements is less
		            // than zero then increment in left
		            else if (x + arr[l] + arr[r] < 0)
		                l++;
		 
		            // if sum is greater than zero than
		            // decrement in right side
		            else
		                r--;
		        }
		    }
		 
		    if (found == false)
		            System.out.println(" No Triplet Found");
		}
}
