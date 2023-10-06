package graphs;

import java.util.ArrayList;
import java.util.List;

class clonegraph$Node {
   public int val;
   public List<clonegraph$Node> neighbors;
   // $FF: synthetic field
   final clonegraph this$0;

   public clonegraph$Node(clonegraph this$0) {
      this.this$0 = this$0;
      this.val = 0;
      this.neighbors = new ArrayList();
   }

   public clonegraph$Node(clonegraph this$0, int _val) {
      this.this$0 = this$0;
      this.val = _val;
      this.neighbors = new ArrayList();
   }

   public clonegraph$Node(clonegraph this$0, int _val, ArrayList _neighbors) {
      this.this$0 = this$0;
      this.val = _val;
      this.neighbors = _neighbors;
   }
}
