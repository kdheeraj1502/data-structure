package bit.masking;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DiffBitPairWise {
   public static int cntBits(List<Integer> list) {
      int[] nSetBits = new int[31];
      Iterator var2 = list.iterator();

      int j;
      while(var2.hasNext()) {
         int val = (Integer)var2.next();

         for(j = 0; j < 32; ++j) {
            if ((val >> j & 1) == 1) {
               int var10002 = nSetBits[j]++;
            }
         }
      }

      long sum = 0L;

      for(j = 0; j < nSetBits.length; ++j) {
         sum += (long)nSetBits[j] * (long)(list.size() - nSetBits[j]) * 2L;
      }

      return (int)(sum % 1000000007L);
   }

   public static int cntBits_self(List<Integer> A) {
      int sum = 0;

      for(int i = 0; i < A.size(); ++i) {
         for(int j = 0; j < A.size(); ++j) {
            sum += setBitCount((Integer)A.get(i) ^ (Integer)A.get(j));
         }
      }

      return sum;
   }

   public static int cntBits_self_1(List<Integer> A) {
      int res = 0;

      for(int i = 0; i < 32; ++i) {
         long countOn = 0L;
         Iterator var5 = A.iterator();

         while(var5.hasNext()) {
            int val = (Integer)var5.next();
            if ((val & 1 << i) != 0) {
               ++countOn;
            }
         }

         long countOff = (long)A.size() - countOn;
         long diff = countOn * countOff * 2L;
         res = (int)((long)res + diff);
      }

      return res;
   }

   private static int setBitCount(int num) {
      int count;
      for(count = 0; num > 0; ++count) {
         num &= num - 1;
      }

      return count;
   }

   public static int cntBits_geeks(List<Integer> A) {
      long res = 0L;

      for(int i = 0; i < 32; ++i) {
         int countOn = 0;
         Iterator var5 = A.iterator();

         while(var5.hasNext()) {
            int val = (Integer)var5.next();
            if ((val & 1 << i) == 1) {
               ++countOn;
            }
         }

         long countOff = (long)(A.size() - countOn);
         long diff = (long)countOn * countOff * 2L;
         res += diff;
      }

      return (int)res % 1000000007;
   }

   public static void main(String[] args) {
      List<Integer> list = Arrays.asList(1, 3, 5, 7);
      System.out.println(cntBits(list));
      System.out.println(cntBits_geeks(list));
   }
}
