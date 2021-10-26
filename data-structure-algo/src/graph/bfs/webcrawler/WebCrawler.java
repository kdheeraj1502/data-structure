package graph.bfs.webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebCrawler {

	private Queue<String> queue;
	private List<String> discoveredWebSitesLists;
	
	public WebCrawler() {
		this.queue = new LinkedList<>();
		this.discoveredWebSitesLists = new ArrayList<>();
	}
	public void discoverTheWeb(String root) {
		this.queue.add(root);
		this.discoveredWebSitesLists.add(root);
		
		while(!queue.isEmpty()) {
			String v = this.queue.remove();
			String rawHtml = readURL(v);
			String regex = "https://(\\w+\\.)*(\\w+)";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(rawHtml);
			
			while(matcher.find()) {
				String actualURL = matcher.group();
				if(!discoveredWebSitesLists.contains(actualURL)) {
					discoveredWebSitesLists.add(actualURL);
					System.out.println("Website has been found with URL :" + actualURL);
					queue.add(actualURL);
				}
			}
		}
	}
	private String readURL(String v) {
		String rawHtml = "";
		try {
			URL url = new URL(v);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String inputLine = "";
			
			while((inputLine = in.readLine()) != null) {
				rawHtml += inputLine;
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rawHtml;
	}
	
	public static void main(String[] args) {
		WebCrawler wc = new WebCrawler();
		String rootURL = "https://www.bbc.com";
		wc.discoverTheWeb(rootURL);
	}
	
}
