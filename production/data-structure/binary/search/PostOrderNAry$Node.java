package binary.search;

import java.util.List;

class PostOrderNAry$Node {
   int val;
   List<PostOrderNAry$Node> children;

   PostOrderNAry$Node(int val) {
      this.val = val;
   }

   PostOrderNAry$Node(int val, List<PostOrderNAry$Node> children) {
      this.val = val;
      this.children = children;
   }
}
