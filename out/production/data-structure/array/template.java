package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class template {
   BufferedReader br;
   StringTokenizer st;

   template() {
      this.br = new BufferedReader(new InputStreamReader(System.in));
      this.st = new StringTokenizer("");
   }

   public String next() {
      while(!this.st.hasMoreTokens()) {
         try {
            this.st = new StringTokenizer(this.br.readLine());
         } catch (IOException var2) {
         }
      }

      return this.st.nextToken();
   }

   public int nextInt() {
      return Integer.parseInt(this.next());
   }

   public long nextLong() {
      return Long.parseLong(this.next());
   }
}
