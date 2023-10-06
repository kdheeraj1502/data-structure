package bit.masking;

public class SetiThBit {
   public static void main(String[] args) {
      System.out.println("set ith bit to 1");
      int num = 309;
      int i = 3;
      System.out.println(num | 1 << i);
      System.out.println("Find val after setting ith bit");
      num = 309;
      i = 3;
      int val = (num & 1 << i) != 0 ? 1 : 0;
      System.out.println(val);
   }
}
