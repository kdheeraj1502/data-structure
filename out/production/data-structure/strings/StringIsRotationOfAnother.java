package strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class StringIsRotationOfAnother {
   public static boolean isEqual(String str1, String str2) {
      if (str1.length() != str2.length()) {
         return false;
      } else {
         Queue<Character> queue1 = new LinkedList();
         Queue<Character> queue2 = new LinkedList();
         char[] var4 = str1.toCharArray();
         int i = var4.length;

         int var6;
         char c;
         for(var6 = 0; var6 < i; ++var6) {
            c = var4[var6];
            queue1.add(c);
         }

         var4 = str2.toCharArray();
         i = var4.length;

         for(var6 = 0; var6 < i; ++var6) {
            c = var4[var6];
            queue2.add(c);
         }

         int len = str2.length();
         i = 0;

         do {
            if (i >= len) {
               return false;
            }

            ++i;
            char c = (Character)queue2.peek();
            queue2.remove();
            queue2.add(c);
         } while(!queue2.equals(queue1));

         System.out.println(queue1.hashCode() + " " + queue2.hashCode());
         return true;
      }
   }

   public static void main(String[] args) {
      new LinkedList();
      new LinkedList();
      ArrayList<String> list1 = new ArrayList();
      ArrayList<String> list2 = new ArrayList();
      list1.add("ABCD");
      list2.add("ABCD");
      System.out.println(list1.equals(list2));
   }
}
