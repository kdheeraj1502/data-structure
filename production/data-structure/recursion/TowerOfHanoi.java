package recursion;

public class TowerOfHanoi {
   public static void main(String[] args) {
      int num = 4;
      System.out.println("The Sequence moves are : \n");
      char src = 'A';
      char temp = 'B';
      char des = 'C';
      towerOfHanoiSelf(num, src, des, temp);
   }

   private static void towerOfHanoi(int num, char src, char des, char temp) {
      if (num >= 1) {
         towerOfHanoi(num - 1, src, temp, des);
         System.out.println("Move " + num + " from " + src + " to " + des);
         towerOfHanoi(num - 1, temp, des, src);
      }
   }

   private static void towerOfHanoiSelf(int num, char src, char des, char temp) {
      if (num >= 1) {
         towerOfHanoiSelf(num - 1, src, temp, des);
         System.out.println("Move " + num + " from " + src + " to " + des);
         towerOfHanoiSelf(num - 1, temp, des, src);
      }
   }
}
