package searchingandsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ekospoj$FastReader {
   BufferedReader br;
   StringTokenizer st;

   public ekospoj$FastReader() {
      this.br = new BufferedReader(new InputStreamReader(System.in));
   }

   String next() {
      while(this.st == null || !this.st.hasMoreElements()) {
         try {
            this.st = new StringTokenizer(this.br.readLine());
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      }

      return this.st.nextToken();
   }

   int nextInt() {
      return Integer.parseInt(this.next());
   }

   long nextLong() {
      return Long.parseLong(this.next());
   }

   double nextDouble() {
      return Double.parseDouble(this.next());
   }

   String nextLine() {
      String str = "";

      try {
         str = this.br.readLine();
      } catch (IOException var3) {
         var3.printStackTrace();
      }

      return str;
   }
}
