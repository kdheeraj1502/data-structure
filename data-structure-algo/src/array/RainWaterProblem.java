package array;

public class RainWaterProblem {

    public static void main(String[] args) {
        int rains[] = { 2, 1, 3, 2, 1, 2, 4, 3, 2, 1, 3, 1 };
        System.out.println(findMaxWaterCollection(rains));
    }

    private static int findMaxWaterCollection(int[] rains) {

        int max = 0;
        int first[] = {0, rains[0]};
        int sub = 0;

        for(int i = 1; i < rains.length; i++) {
            int j = i;
            while(rains[j] < first[1]) {
                if(j >= rains.length) {
                    first[0] = i + 1;
                    first[1] = rains[i + 1];
                    break;
                }
                sub += rains[i];
            }

            int min = Math.min(first[1], rains[i]);
            int width = i - first[0] - 1;
            int area = (min * width) - sub;
            max += area;
            sub = 0;
            first[0] = i;
            first[1] = rains[i];
        }
        return max;
    }/// 6 => 3 * 3 = 9 - 6 = 3
}
