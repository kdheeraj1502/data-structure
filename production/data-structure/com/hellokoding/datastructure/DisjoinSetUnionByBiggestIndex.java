package com.hellokoding.datastructure;

public class DisjoinSetUnionByBiggestIndex {
   int[] parents;
   int N;

   DisjoinSetUnionByBiggestIndex(int N) {
      this.N = N;
      this.parents = new int[N];
      this.initDisjoinSet();
   }

   void initDisjoinSet() {
      for(int i = 0; i < this.N; this.parents[i] = i++) {
      }

   }

   int findRoot(int x) {
      if (this.parents[x] != x) {
         this.parents[x] = this.findRoot(this.parents[x]);
      }

      return this.parents[x];
   }

   void union(int x, int y) {
      int rootOfX = this.findRoot(x);
      int rootOfY = this.findRoot(y);
      if (rootOfX != rootOfY) {
         this.parents[rootOfX] = rootOfY;
      }
   }

   public static void main(String[] args) {
      int N = 4;
      DisjoinSetUnionByBiggestIndex disjoinSet = new DisjoinSetUnionByBiggestIndex(N);
      disjoinSet.union(0, 1);
      disjoinSet.union(1, 2);
      if (disjoinSet.findRoot(1) == disjoinSet.findRoot(2)) {
         System.out.println("1 is in the same set with 2");
      } else {
         System.out.println("1 is not in the same set with 2");
      }

      if (disjoinSet.findRoot(1) == disjoinSet.findRoot(3)) {
         System.out.println("1 is in the same set with 3");
      } else {
         System.out.println("1 is not in the same set with 3");
      }

   }
}
