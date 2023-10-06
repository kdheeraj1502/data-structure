package misclaneous;

import java.util.Comparator;

class largestnumber$Sort implements Comparator<Integer> {
   // $FF: synthetic field
   final largestnumber this$0;

   largestnumber$Sort(largestnumber this$0) {
      this.this$0 = this$0;
   }

   public int compare(Integer o1, Integer o2) {
      String a = "" + o1 + o2;
      String b = "" + o2 + o1;
      return a.compareTo(b);
   }
}
