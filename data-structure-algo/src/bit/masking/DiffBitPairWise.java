package bit.masking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class DiffBitPairWise {

	public static int cntBits(List<Integer> list) {
		int[] nSetBits = new int[31];
		for (int val : list) {
			for (int j = 0; j < 32; j++) {
				if (((val >> j) & 1) == 1) {
					nSetBits[j]++;
				}
			}
		}
		long sum = 0;
		for (int i = 0; i < nSetBits.length; i++) {
			sum += (long) nSetBits[i] * (list.size() - nSetBits[i]) * 2;
		}
		return (int) (sum % 1000000007);
	}

	public static int cntBits_self(List<Integer> A) {
		int sum = 0;
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.size(); j++) {
				sum += setBitCount(A.get(i) ^ A.get(j));
			}
		}
		return sum;
	}

	public static int cntBits_self_1(List<Integer> A) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			long countOn = 0;
			for (int val : A) {
				if ((val & (1 << i)) != 0) {
					countOn++;
				}
			}
			long countOff = A.size() - countOn;
			long diff = countOn * countOff * 2;
			res += diff;
		}
		return res;
	}

	private static int setBitCount(int num) {
		int count = 0;
		while (num > 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}
	
    public static int cntBits_geeks(List<Integer> A) {
        long res = 0;
        for(int i = 0; i < 32; i++){
            int countOn = 0;
            for(int val : A){
                if((val & (1 << i)) == 1){
                    countOn++;
                }
            }
            long countOff = A.size() - countOn;
            long diff = countOn * countOff * 2;
            res += diff;
        }
        return (int)res%1000000007;
    }

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 3, 5, 7);
		System.out.println(cntBits(list));

		System.out.println(cntBits_geeks(list));
	}
}
