package stackandqueue;

public class circulartourPetrolpump {
   public static void main(String[] args) {
   }

   int tour(int[] petrol, int[] distance) {
      int tank = 0;
      int total = 0;
      int idx = 0;

      for(int i = 0; i < petrol.length; ++i) {
         int consume = petrol[i] - distance[i];
         tank += consume;
         if (tank < 0) {
            idx = i + 1;
            tank = 0;
         }

         total += consume;
      }

      return total < 0 ? -1 : idx;
   }
}
