package bit.masking.xor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Find2NonRepeatingForOddNums {
   public static void find2OddNumberReapeatingNums(int[] num) {
      int xor = 0;

      int temp;
      for(temp = 0; temp < num.length; ++temp) {
         xor ^= num[temp];
      }

      temp = xor;

      int digit;
      for(digit = 0; temp > 0; ++digit) {
         temp /= 2;
      }

      temp = xor;
      int pos = 0;

      for(int i = 0; i <= digit; ++i) {
         if ((temp & 1 << i) > 0) {
            pos = i;
            break;
         }
      }

      List<Integer> left = new ArrayList();

      int i;
      for(i = 0; i < num.length; ++i) {
         if ((num[i] & 1 << pos) > 0) {
            left.add(num[i]);
         }
      }

      temp = xor;

      for(i = 0; i < left.size(); ++i) {
         temp ^= (Integer)left.get(i);
      }

      int b = temp ^ xor;
      System.out.println("a is " + temp + " b is " + b);
      System.out.println("a in binary " + Integer.toBinaryString(temp) + " b in binary is " + Integer.toBinaryString(b));
      System.out.println("Position is " + pos);
      System.out.println(Integer.toBinaryString(temp ^ b));
   }

   public static void find2OddNumberReapeatingNums_self(int[] num) {
      int xor = 0;
      int[] var2 = num;
      int var3 = num.length;

      int position;
      for(position = 0; position < var3; ++position) {
         int val = var2[position];
         xor ^= val;
      }

      int shiftCount = false;
      position = xor ^ -xor;
      int shiftCount = 0;
      List<Integer> setBitList = new ArrayList();
      List<Integer> offSetBitList = new ArrayList();
      int[] var7 = num;
      int b = num.length;

      int val;
      for(int var9 = 0; var9 < b; ++var9) {
         val = var7[var9];
         if ((val & 1 << shiftCount) != 0) {
            setBitList.add(val);
         } else {
            offSetBitList.add(val);
         }
      }

      int a = 0;
      b = 0;

      Iterator var15;
      for(var15 = setBitList.iterator(); var15.hasNext(); a ^= val) {
         val = (Integer)var15.next();
      }

      for(var15 = offSetBitList.iterator(); var15.hasNext(); b ^= val) {
         val = (Integer)var15.next();
      }

      System.out.println("First num is " + a + " second num is " + b);
   }

   public static void main(String[] args) {
      int[] num = new int[]{18, 24, 24, 21, 10, 29, 8, 10, 29, 18};
      find2OddNumberReapeatingNums(num);
      int a = 86;
      Object obj = Integer.valueOf(a);
      System.out.println(obj);
      int b = (Integer)obj;
      System.out.println(b);
      find2OddNumberReapeatingNums_self(num);
   }
}
