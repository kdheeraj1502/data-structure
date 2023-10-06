package queue;

import java.util.ArrayDeque;

public class CircularTourPetrolPump {
   public static int circularTour(int[][] num) {
      ArrayDeque<Integer> queue = new ArrayDeque();
      int next = 0;
      int prev = false;
      int count = 0;
      int petrol = 0;

      do {
         if (queue.size() == num.length) {
            if (petrol >= 0) {
               return (Integer)queue.remove();
            }

            return -1;
         }

         while(petrol >= 0 && queue.size() != num.length) {
            queue.add(next);
            petrol += num[next][0] - num[next][1];
            next = (next + 1) % num.length;
         }

         while(petrol < 0 && queue.size() > 0) {
            int prev = (Integer)queue.remove();
            petrol -= num[prev][0] - num[prev][1];
         }

         ++count;
      } while(count != num.length);

      return -1;
   }

   public static void main(String[] args) {
      int[][] tour = new int[][]{{8, 6}, {1, 4}, {7, 6}};
      System.out.println(circularTour(tour));
   }
}
