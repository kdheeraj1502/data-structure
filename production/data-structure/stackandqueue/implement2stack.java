package stackandqueue;

public class implement2stack {
   void push1(int x, TwoStack sq) {
      ++sq.top1;
      if (sq.top1 != sq.top2) {
         sq.arr[sq.top1] = x;
      }
   }

   void push2(int x, TwoStack sq) {
      --sq.top2;
      if (sq.top2 != sq.top1) {
         sq.arr[sq.top2] = x;
      }
   }

   int pop1(TwoStack sq) {
      if (sq.top1 < 0) {
         return -1;
      } else {
         int rv = sq.arr[sq.top1];
         sq.arr[sq.top1] = 0;
         --sq.top1;
         return rv;
      }
   }

   int pop2(TwoStack sq) {
      if (sq.top2 == sq.size) {
         return -1;
      } else {
         int rv = sq.arr[sq.top2];
         sq.arr[sq.top2] = 0;
         ++sq.top2;
         return rv;
      }
   }
}
