package string;

public class ReverseWord {
   public String reverseWord(String str) {
      int lower = 0;
      int upper = -1;
      char[] ch = str.toCharArray();
      ReverseString rs = new ReverseString();

      for(int i = 0; i <= ch.length; ++i) {
         if (i != ch.length && ch[i] != ' ') {
            ++upper;
         } else {
            rs.reverseUtil(ch, lower, upper);
            lower = i + 1;
            upper = i;
         }
      }

      rs.reverseUtil(ch, 0, ch.length - 1);
      return new String(ch);
   }

   public static void main(String[] args) {
      ReverseWord rw = new ReverseWord();
      System.out.println(rw.reverseWord("Hello World"));
   }
}
