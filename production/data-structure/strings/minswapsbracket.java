package strings;

public class minswapsbracket {
   public static void main(String[] args) {
      minswapoptimised("[]][][");
   }

   public static void minswap(String s) {
      int open = 0;
      int k = 0;
      int minswap = 0;
      char[] sarr = s.toCharArray();
      int[] openarr = new int[s.length()];

      int j;
      for(j = 0; j < s.length(); ++j) {
         if (sarr[j] == '[') {
            openarr[k++] = j;
         }
      }

      j = 0;

      for(int i = 0; i < s.length(); ++i) {
         if (sarr[i] == '[') {
            ++open;
            ++j;
         } else if (sarr[i] == ']') {
            --open;
         }

         if (open < 0) {
            minswap += openarr[j] - i;
            char temp = sarr[i];
            sarr[i] = sarr[openarr[j]];
            sarr[openarr[j]] = temp;
            open = 1;
            ++j;
         }
      }

      System.out.println(minswap);
   }

   public static void minswapoptimised(String s) {
      int open = 0;
      int k = false;
      int minswap = 0;
      int fault = 0;
      int close = 0;
      char[] sarr = s.toCharArray();

      for(int i = 0; i < s.length(); ++i) {
         if (sarr[i] == ']') {
            ++close;
            fault = close - open;
         } else {
            ++open;
            if (fault > 0) {
               minswap += fault;
               --fault;
            }
         }
      }

      System.out.println(minswap);
   }
}
