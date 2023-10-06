package binary.search;

class SumLevel {
   int sum;
   int level;
   TreeNode node;

   SumLevel(TreeNode node, int sum, int level) {
      this.node = node;
      this.sum = sum;
      this.level = level;
   }

   public String toString() {
      return "[sum = " + this.sum + ", level = " + this.level + ", node val = " + this.node.val + "]";
   }
}
