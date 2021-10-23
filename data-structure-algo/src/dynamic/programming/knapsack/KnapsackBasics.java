package dynamic.programming.knapsack;

/**
 * x is binary 0 or 1
 * 
 * v is value of i th items
 * 
 * w is weight of i th items
 * 
 * m is maximum capacity of knapsack
 * 
 * v * 1 or v * 0
 * 
 * W <= M(max weight)
 * 
 * 
 * if include than M-W and value is  the current value + values of N-i previous items
 * if not  included then M weight and value is value of N - 1 previous items
 * 
 * The product has some weight and some value
 * maximize the value and minimize the weight
 * 
 * 
 * DIVISIBLE Knapsack - fast algo   // favorable 
 * 				sort and then pick most valuable item
 * 				(nlogn) sorting + o(n) linear search
 * 
 * 0 - 1 Knapsack - COmplex problem - Weather include the item or exclude the item
 * 
 * 
 * S[i][w] = Math.max(S[i - 1][w], v(i) + S[i - 1][M-w]);
 * 
 * 
 * @author dheerajkumar02
 *
 */
public class KnapsackBasics {

}
