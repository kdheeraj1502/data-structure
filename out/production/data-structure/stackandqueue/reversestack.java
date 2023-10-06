package stackandqueue;

public class reversestack {
   public static void main(String[] args) throws Exception {
      stackusingarray st = new stackusingarray(5);
      st.push(5);
      st.push(4);
      st.push(3);
      st.push(2);
      st.push(1);
      st.display();
      reversewithoutextrastack(st);
      st.display();
   }

   public static void reverse(stackusingarray og, stackusingarray helper, int idx) throws Exception {
      if (og.size() != 0) {
         int top = og.pop();
         reverse(og, helper, idx + 1);
         helper.push(top);
         if (idx == 0) {
            while(!helper.isEmpty()) {
               og.push(helper.pop());
            }
         }

      }
   }

   public static void reversewithoutextrastack(stackusingarray og) throws Exception {
      if (og.size() != 0) {
         int top = og.pop();
         reversewithoutextrastack(og);
         insertbottom(og, top);
      }
   }

   private static void insertbottom(stackusingarray og, int element) throws Exception {
      if (og.size() == 0) {
         og.push(element);
      } else {
         int top = og.pop();
         insertbottom(og, element);
         og.push(top);
      }
   }
}
