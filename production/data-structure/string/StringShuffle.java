package string;

import java.util.Arrays;

public class StringShuffle {
   public String restoreString(String s, int[] indices) {
      char[] ch = new char[indices.length];

      for(int i = 0; i < indices.length; ++i) {
         ch[indices[i]] = s.charAt(i);
      }

      return new String(ch);
   }

   public char[] restoreString(String s) {
      char[] character = new char[s.length()];
      int index = -1;

      int first;
      int second;
      for(first = 0; first < s.length(); ++first) {
         second = s.charAt(first);
         if (second >= 48 && second <= 57) {
            index = first;
            break;
         }
      }

      first = 0;
      second = index;

      for(int j = 0; first < index && second < s.length(); character[j++] = s.charAt(second++)) {
         character[j++] = s.charAt(first++);
      }

      return character;
   }

   public static void main(String[] args) {
      StringShuffle ss = new StringShuffle();
      String str = "codeleet";
      int[] indices = new int[]{4, 5, 6, 7, 0, 2, 1, 3};
      System.out.println(ss.restoreString(str, indices));
      System.out.println(Arrays.toString(ss.restoreString("ABCDE12345")));
   }
}
