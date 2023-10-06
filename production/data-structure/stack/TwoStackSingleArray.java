package stack;

public class TwoStackSingleArray {
   private int top1 = -1;
   private int top2;
   private int maxCapacity = 10;
   private int[] elementData;

   TwoStackSingleArray() {
      this.top2 = this.maxCapacity;
      this.elementData = new int[this.maxCapacity];
   }

   TwoStackSingleArray(int maxCapacity) {
      this.top2 = maxCapacity - 1;
      this.maxCapacity = maxCapacity;
      this.elementData = new int[maxCapacity];
   }

   public void stackPush(int val, int stack) {
      if (this.top1 < this.top2 - 1) {
         if (stack == 0) {
            this.elementData[++this.top1] = val;
         } else if (stack == 1) {
            this.elementData[--this.top2] = val;
         }
      } else {
         System.out.println("Stack is full");
      }

   }

   public int stackPop1() {
      if (this.top1 >= 0) {
         int val = this.elementData[this.top1--];
         return val;
      } else {
         System.out.println("Stack is empty");
         return Integer.MIN_VALUE;
      }
   }

   public int stackPop2() {
      if (this.top2 < this.maxCapacity) {
         int val = this.elementData[this.top2++];
         return val;
      } else {
         System.out.println("Stack is empty");
         return Integer.MIN_VALUE;
      }
   }

   public static void main(String[] args) {
      TwoStackSingleArray tsa = new TwoStackSingleArray();

      int max;
      for(max = 18; max < 30; ++max) {
         tsa.stackPush(max, max % 2);
      }

      max = tsa.top1;

      int i;
      for(i = 0; i < tsa.top2; ++i) {
         System.out.println(tsa.stackPop1());
      }

      for(i = tsa.maxCapacity - 1; i > max; --i) {
         System.out.println(tsa.stackPop2());
      }

   }
}
