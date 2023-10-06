package heap;

import java.util.ArrayList;

public class minheap {
   ArrayList<Integer> heap = new ArrayList();

   public void add(int item) {
      this.heap.add(item);
      this.upheapify(this.heap.size() - 1);
   }

   private void upheapify(int ci) {
      int pi = (ci - 1) / 2;
      if ((Integer)this.heap.get(ci) < (Integer)this.heap.get(pi)) {
         this.swap(pi, ci);
         this.upheapify(pi);
      }

   }

   private void swap(int pi, int ci) {
      int temp = (Integer)this.heap.get(pi);
      this.heap.set(pi, this.heap.get(ci));
      this.heap.set(ci, temp);
   }

   public int remove() {
      int li = this.heap.size() - 1;
      this.swap(0, li);
      int ans = (Integer)this.heap.remove(li);
      this.downheapify(0);
      return ans;
   }

   private void downheapify(int pi) {
      int lci = 2 * pi + 1;
      int rci = 2 * pi + 2;
      int mini = pi;
      if (lci < this.heap.size() && (Integer)this.heap.get(lci) < (Integer)this.heap.get(pi)) {
         mini = lci;
      }

      if (rci < this.heap.size() && (Integer)this.heap.get(rci) < (Integer)this.heap.get(mini)) {
         mini = rci;
      }

      if (mini != pi) {
         this.swap(pi, mini);
         this.downheapify(mini);
      }

   }

   public void display() {
      System.out.println(this.heap);
   }
}
