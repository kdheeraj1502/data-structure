package stackandqueue;

public class kqueueclient {
   public static void main(String[] args) {
      kqueue q = new kqueue(10, 3);
      q.add(1, 0);
      q.add(2, 0);
      q.add(3, 0);
      q.display(0);
      System.out.println(q.remove(0));
      q.display(0);
   }
}
