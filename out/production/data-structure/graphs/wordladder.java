package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class wordladder {
   public static void main(String[] args) {
      String begin = "hit";
      String end = "cog";
      ArrayList<String> arr = new ArrayList();
      arr.add("hot");
      arr.add("dot");
      arr.add("tog");
      arr.add("cog");
      System.out.println(length(begin, end, arr));
   }

   public static int length(String begin, String end, ArrayList<String> arr) {
      if (!arr.contains(end)) {
         return 0;
      } else {
         HashSet<String> list = new HashSet();
         Iterator var4 = arr.iterator();

         while(var4.hasNext()) {
            String string = (String)var4.next();
            list.add(string);
         }

         LinkedList<String> queue = new LinkedList();
         queue.addLast(begin);
         int depth = 0;

         while(!queue.isEmpty()) {
            ++depth;
            int sz = queue.size();

            while(sz > 0) {
               String rv = (String)queue.removeFirst();
               --sz;

               for(int i = 0; i < rv.length(); ++i) {
                  for(int j = 97; j <= 122; ++j) {
                     char ch = (char)j;
                     if (ch != rv.charAt(i)) {
                        String ns = rv.substring(0, i) + ch + rv.substring(i + 1);
                        if (ns.compareTo(end) == 0) {
                           return depth + 1;
                        }

                        if (list.contains(ns)) {
                           queue.addLast(ns);
                           list.remove(ns);
                        }
                     }
                  }
               }
            }
         }

         return 0;
      }
   }
}
