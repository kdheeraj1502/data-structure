package string;

public class PrintAnagram {
   static int count = 1;

   public void printAnagram(String str) {
      int n = str.length();
      char[] ch = str.toCharArray();
      this.printAnagram(ch, n);
   }

   private void printAnagram(char[] ch, int max) {
      if (max == 1) {
         System.out.print(ch);
         System.out.println(" : " + count++);
      } else {
         for(int i = -1; i < max - 1; ++i) {
            char temp;
            if (i != -1) {
               temp = ch[i];
               ch[i] = ch[max - 1];
               ch[max - 1] = temp;
            }

            this.printAnagram(ch, max - 1);
            if (i != -1) {
               temp = ch[i];
               ch[i] = ch[max - 1];
               ch[max - 1] = temp;
            }
         }

      }
   }

   public static void main(String[] args) {
      PrintAnagram pa = new PrintAnagram();
      pa.printAnagram("123");
   }
}
