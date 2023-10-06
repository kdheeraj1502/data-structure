package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringPermuation {
   static int count = 1;

   public static List<List<Character>> permute(char[] ch, int max, List<List<Character>> result) {
      if (max != 1) {
         for(int i = -1; i < max - 1; ++i) {
            char temp;
            if (i != -1) {
               temp = ch[i];
               ch[i] = ch[max - 1];
               ch[max - 1] = temp;
            }

            permute(ch, max - 1, result);
            if (i != -1) {
               temp = ch[i];
               ch[i] = ch[max - 1];
               ch[max - 1] = temp;
            }
         }

         return result;
      } else {
         System.out.print(ch);
         System.out.println(" : " + count++);
         List<Character> curr = new ArrayList();
         char[] var4 = ch;
         int var5 = ch.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            char c = var4[var6];
            curr.add(c);
         }

         result.add(curr);
         return result;
      }
   }

   public static void main(String[] args) {
      String str = "Dheeraj";
      Character[] charObjectArray = (Character[])str.chars().mapToObj((c) -> {
         return (char)c;
      }).toArray((x$0) -> {
         return new Character[x$0];
      });
      List<List<Character>> result = permute_self(charObjectArray);
      System.out.println(result.size());
   }

   public static List<List<Character>> permute_self(Character[] ch) {
      List<List<Character>> result = new ArrayList();
      permute_self(ch, result, 0);
      return result;
   }

   public static void permute_self(Character[] ch, List<List<Character>> result, int index) {
      if (index == ch.length - 1) {
         result.add(Arrays.stream(ch).collect(Collectors.toList()));
      } else {
         for(int i = index; i < ch.length; ++i) {
            ch = swap(ch, index, i);
            permute_self(ch, result, index + 1);
            ch = swap(ch, index, i);
         }
      }

   }

   private static Character[] swap(Character[] ch, int i, int j) {
      char temp = ch[i];
      ch[i] = ch[j];
      ch[j] = temp;
      return ch;
   }
}
