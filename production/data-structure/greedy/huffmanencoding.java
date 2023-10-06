package greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class huffmanencoding {
   public static void main(String[] args) {
      String s = "qwertyuiopasdfghjklzxcvbn";
      int[] f = new int[]{8, 9, 14, 19, 20, 21, 21, 25, 33, 45, 50, 50, 66, 68, 70, 73, 74, 75, 76, 82, 85, 90, 94, 97, 100};
      ArrayList<String> ans = huffmanCodes(s, f, f.length);
      System.out.println(ans);
   }

   public static ArrayList<String> huffmanCodes(String s, int[] f, int N) {
      PriorityQueue<Node> heap = new PriorityQueue();

      for(int i = 0; i < s.length(); ++i) {
         heap.add(new Node(f[i], s.charAt(i)));
      }

      Node root = null;

      while(heap.size() > 1) {
         Node one = (Node)heap.remove();
         Node two = (Node)heap.remove();
         Node nn = new Node(one.data + two.data, '-');
         nn.left = one;
         nn.right = two;
         root = nn;
         heap.add(nn);
      }

      ArrayList<String> fans = new ArrayList();
      print(root, "", fans);
      return fans;
   }

   private static void print(Node root, String ans, ArrayList<String> fans) {
      if (root != null) {
         if (root.left == null && root.right == null && root.ch != '-') {
            fans.add(ans);
         } else {
            print(root.left, ans + "0", fans);
            print(root.right, ans + "1", fans);
         }
      }
   }
}
