package heap;

import java.util.ArrayList;

public class maxheap {
   ArrayList<Integer> heap = new ArrayList();

   public void add(int item) {
      this.heap.add(item);
      this.upheapify(this.heap.size() - 1);
   }

   public void upheapify(int ci) {
      int pi = (ci - 1) / 2;
      if ((Integer)this.heap.get(ci) > (Integer)this.heap.get(pi)) {
         this.swap(pi, ci);
         this.upheapify(pi);
      }

   }

   public void swap(int pi, int ci) {
      int temp = (Integer)this.heap.get(pi);
      this.heap.set(pi, this.heap.get(ci));
      this.heap.set(ci, temp);
   }

   public void remove() {
      int li = this.heap.size() - 1;
      this.swap(0, li);
      System.out.println(this.heap.remove(li));
      this.downheapify(0);
   }

   public void downheapify(int pi) {
      int lci = 2 * pi + 1;
      int rci = 2 * pi + 2;
      int maxi = pi;
      if (lci < this.heap.size() && (Integer)this.heap.get(lci) > (Integer)this.heap.get(pi)) {
         maxi = lci;
      }

      if (rci < this.heap.size() && (Integer)this.heap.get(rci) > (Integer)this.heap.get(maxi)) {
         maxi = rci;
      }

      if (maxi != pi) {
         this.swap(pi, maxi);
         this.downheapify(maxi);
      }

   }

   public void downheapifymod(int pi, int end) {
      int lci = 2 * pi + 1;
      int rci = 2 * pi + 2;
      int maxi = pi;
      if (lci < end && (Integer)this.heap.get(lci) > (Integer)this.heap.get(pi)) {
         maxi = lci;
      }

      if (rci < end && (Integer)this.heap.get(rci) > (Integer)this.heap.get(maxi)) {
         maxi = rci;
      }

      if (maxi != pi) {
         this.swap(pi, maxi);
         this.downheapifymod(maxi, end);
      }

   }

   public void display() {
      System.out.println(this.heap);
   }
}
