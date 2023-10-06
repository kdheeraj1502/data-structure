package stack;

public class InfixToPreFixBook {
   public static String infixToPreFix(String expn) {
      char[] arr = expn.toCharArray();
      reverseString(arr);
      replaceParenthesis(arr);
      arr = InfixToPostFix.infixToPostFix(arr);
      reverseString(arr);
      expn = new String(arr);
      return expn;
   }

   private static void replaceParenthesis(char[] arr) {
      int start = 0;

      for(int end = arr.length - 1; start <= end; ++start) {
         if (arr[start] == '(') {
            arr[start] = ')';
         } else if (arr[start] == ')') {
            arr[start] = '(';
         }
      }

   }

   private static void reverseString(char[] arr) {
      int start = 0;

      char temp;
      for(int end = arr.length - 1; start < end; arr[end--] = temp) {
         temp = arr[start];
         arr[start++] = arr[end];
      }

   }

   public static void main(String[] args) {
      String expn = "10+((3))*5/(16-4)";
      String value = infixToPreFix(expn);
      System.out.println("Inflix Expn : " + expn);
      System.out.println("Postfix expn: " + value);
   }
}
