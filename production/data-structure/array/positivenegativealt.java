package array;

public class positivenegativealt {
   public static void main(String[] args) {
      int[] arr = new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
      posnegalt(arr);
   }

   public static void posnegalt(int[] arr) {
      int i = 0;

      int wrongindex;
      while(i < arr.length) {
         if ((i % 2 != 0 || arr[i] < 0) && (i % 2 == 0 || arr[i] >= 0)) {
            ++i;
         } else {
            wrongindex = i;
            if (i % 2 == 0) {
               while(i < arr.length && arr[i] >= 0) {
                  ++i;
               }
            } else {
               while(i < arr.length && arr[i] < 0) {
                  ++i;
               }
            }

            if (i == arr.length) {
               break;
            }

            rotatearr(arr, wrongindex, i);
            i = wrongindex + 1;
         }
      }

      for(wrongindex = 0; wrongindex < arr.length; ++wrongindex) {
         System.out.println(arr[wrongindex]);
      }

   }

   private static void rotatearr(int[] arr, int wrongindex, int lastindex) {
      int temp = arr[lastindex];

      for(int i = lastindex - 1; i >= wrongindex; --i) {
         arr[i + 1] = arr[i];
      }

      arr[wrongindex] = temp;
   }
}
