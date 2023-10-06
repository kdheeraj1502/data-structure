package heap;

class isbtaheap$Node {
   public int data;
   public isbtaheap$Node left;
   public isbtaheap$Node right;

   isbtaheap$Node(int data) {
      this.data = data;
   }

   isbtaheap$Node(int data, isbtaheap$Node left, isbtaheap$Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
}
