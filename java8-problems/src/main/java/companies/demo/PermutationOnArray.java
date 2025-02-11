package companies.demo;

import java.util.Arrays;

public class PermutationOnArray {

    public static void main(String[] args) {
        int num[] = {1, 2, 3};
        permute(num, 0);
    }

    private static void permute(int num[], int idx) {
        if (idx >= num.length) {
            System.out.println(Arrays.toString(num));
        }
        for (int i = idx; i < num.length; i++) { // i = 0 , idx = 0  , num = 1, 2, 3
            swap(i, idx, num);
            permute(num, idx + 1);
            swap(i, idx, num);
        }
    }

    private static void swap(int i, int j, int[] ans) {
        if(i < ans.length && j < ans.length) {
            int temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
        }
    }
}

