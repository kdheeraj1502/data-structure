package queue;

import java.util.ArrayDeque;

public class ConvertXY {
   public static int convertXY(int src, int dst) {
      ArrayDeque<Integer> queue = new ArrayDeque();
      int[] num = new int[100];
      int steps = 0;
      int index = 0;
      queue.add(src);

      while(queue.size() != 0) {
         int value = (Integer)queue.remove();
         num[index++] = value;
         if (value == dst) {
            for(int i = 0; i < index; ++i) {
               System.out.println(num[i]);
            }

            System.out.println("Steps counter :: " + steps);
            return steps;
         }

         ++steps;
         if (value < dst) {
            queue.add(value * 2);
         } else {
            queue.add(value - 1);
         }
      }

      return -1;
   }

   public static int convertXY_self(int src, int dst) {
      ArrayDeque<Integer> queue = new ArrayDeque();
      int steps = 0;
      int index = 0;
      queue.add(src);
      int[] nums = new int[100];

      while(queue.size() != 0) {
         int value = (Integer)queue.remove();
         nums[index++] = value;
         if (value == dst) {
            for(int i = 0; i < index; ++i) {
               System.out.println(nums[i]);
            }

            System.out.println("Steps count :: " + steps);
            return steps;
         }

         ++steps;
         if (value < dst) {
            queue.add(value * 2);
         }

         if (value > dst) {
            queue.add(value - 1);
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      System.out.println(convertXY_self(3, 81));
   }
}
