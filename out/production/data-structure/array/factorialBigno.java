package array;

public class factorialBigno {
   public static void main(String[] args) {
      fact(5);
   }

   public static void fact(int n) {
      int[] arr = new int[1000];
      int carry = 0;
      arr[0] = 1;
      int nod = 1;

      int i;
      for(i = 1; i <= n; ++i) {
         for(int j = 0; j < nod; ++j) {
            int mult = i * arr[j] + carry;
            arr[j] = mult % 10;
            carry = mult / 10;
         }

         while(carry > 0) {
            arr[nod] = carry % 10;
            carry /= 10;
            ++nod;
         }
      }

      for(i = nod - 1; i >= 0; --i) {
         System.out.print(arr[i]);
      }

   }
}
