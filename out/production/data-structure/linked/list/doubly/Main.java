package linked.list.doubly;

public class Main {
   public static void main(String[] args) {
      DoubleLinkedList list = new DoubleLinkedList();
      list.addHead(32);
      list.addHead(26);
      list.addHead(17);
      list.addHead(17);
      list.addHead(13);
      list.addHead(9);

      for(Node node = ReverseList.reverse(list.getHead()); node != null; node = node.next) {
         System.out.print(node.val + ", ");
      }

      list.addBack(132);
      list.addBack(126);
      list.addBack(117);
      list.addBack(117);
      list.addBack(113);
      list.addBack(19);
      System.out.print("list of val in head : ");
      list.print(list.getHead());
      System.out.println();
      list.sortedInsert(15);
      System.out.print("list of val in head after sorted insert : ");
      list.print(list.getHead());
      System.out.println();
      System.out.println(list.removeHead());
      System.out.println();
      System.out.print("list of val after head remove : ");
      list.print(list.getHead());
      System.out.println();
      list.removeNode(26);
      System.out.print("list of val in head after removing 26 : ");
      list.print(list.getHead());
      System.out.println();
      RemoveDuplicate.removeDuplicate(list.getHead(), list);
      list.print(list.getHead());
      System.out.println();
      Node prev = ReverseList.reverseByAdding(list.getHead());
      list.print(prev);
      System.out.println();

      while(prev != null) {
         Integer nextVal = prev.next != null ? prev.next.val : null;
         Integer prevVal = prev.prev != null ? prev.prev.val : null;
         System.out.println("Current val : " + prev.val + " [ next : " + nextVal + " :: prev is " + prevVal + " ]");
         prev = prev.next;
      }

   }
}
