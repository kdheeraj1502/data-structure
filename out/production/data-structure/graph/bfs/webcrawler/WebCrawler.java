package graph.bfs.webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
   private Queue<String> queue = new LinkedList();
   private List<String> discoveredWebSitesLists = new ArrayList();

   public void discoverTheWeb(String root) {
      this.queue.add(root);
      this.discoveredWebSitesLists.add(root);

      while(!this.queue.isEmpty()) {
         String v = (String)this.queue.remove();
         String rawHtml = this.readURL(v);
         String regex = "https://(\\w+\\.)*(\\w+)";
         Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(rawHtml);

         while(matcher.find()) {
            String actualURL = matcher.group();
            if (!this.discoveredWebSitesLists.contains(actualURL)) {
               this.discoveredWebSitesLists.add(actualURL);
               System.out.println("Website has been found with URL :" + actualURL);
               this.queue.add(actualURL);
            }
         }
      }

   }

   private String readURL(String v) {
      String rawHtml = "";

      try {
         URL url = new URL(v);
         BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

         for(String inputLine = ""; (inputLine = in.readLine()) != null; rawHtml = rawHtml + inputLine) {
         }

         in.close();
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      return rawHtml;
   }

   public static void main(String[] args) {
      WebCrawler wc = new WebCrawler();
      String rootURL = "https://www.bbc.com";
      wc.discoverTheWeb(rootURL);
   }
}
