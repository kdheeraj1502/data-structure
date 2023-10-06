package bitmasking;

public class Practice {
   public static void main(String[] args) {
      int i = 13;
      int j = 60;
      i ^= j;
      j ^= i;
      int var10000 = i ^ j;
      int val = 1;

      do {
         ++val;
         ++val;
      } while(val++ > 25);

      System.out.println(val);
   }
}
