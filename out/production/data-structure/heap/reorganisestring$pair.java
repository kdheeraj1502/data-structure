package heap;

public class reorganisestring$pair implements Comparable<reorganisestring$pair> {
   char ch;
   int frq;

   reorganisestring$pair(char c, int f) {
      this.ch = c;
      this.frq = f;
   }

   public int compareTo(reorganisestring$pair o) {
      return o.frq - this.frq;
   }
}
