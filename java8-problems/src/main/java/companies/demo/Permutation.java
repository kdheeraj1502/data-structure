package companies.demo;


import java.util.Arrays;

public class Permutation {

    public static void main(String[] args) {
        String str = "123";
        permute(str, 0, new char[3], new boolean[3]);
    }

    private static void permute(String str, int idx, char ans[], boolean used[]) {
        if(idx >= str.length()){
            System.out.println(Arrays.toString(ans));
        }

        for(int i = 0; i < str.length(); i++) {
            if(!used[i]) {
                ans[idx] = str.charAt(i);
                used[i] = true;
                permute(str, idx + 1, ans, used);
                used[i] = false;
            }
        }
    }
}
