package greedy;

public class huffmanencoding$Node implements Comparable<huffmanencoding$Node> {
   int data;
   char ch;
   huffmanencoding$Node left;
   huffmanencoding$Node right;

   huffmanencoding$Node(int d, char c) {
      this.data = d;
      this.ch = c;
      this.left = null;
      this.right = null;
   }

   public int compareTo(huffmanencoding$Node o) {
      return this.data == o.data ? 1 : this.data - o.data;
   }
}
