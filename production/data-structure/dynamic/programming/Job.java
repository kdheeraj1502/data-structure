package dynamic.programming;

class Job implements Comparable<Job> {
   int start;
   int finish;
   int profit;

   Job(int start, int finish, int profit) {
      this.start = start;
      this.finish = finish;
      this.profit = profit;
   }

   public int compareTo(Job obj) {
      return this.finish - obj.finish;
   }
}
