package graph;

import java.util.ArrayList;
import java.util.List;

public class UnDirectedGraph {

	int size;
	List<List<Edge>> adjacency;
	
	UnDirectedGraph(int size){
		this.size = size;
		this.adjacency = new ArrayList<>();
		int  a = size;
		while(a > 0) {
			adjacency.add(new ArrayList<>());
			a--;
		}
	}
	
	public void addUndirected(int src, int des, int cost) {
		addDirected(src, des, cost);
		addDirected(des, src, cost);
	}
	
	private void addDirected(int src, int des, int cost) {
		Edge edge = new Edge(des, cost);
		adjacency.get(src).add(edge);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<List<Edge>> getAdjacency() {
		return adjacency;
	}

	public void setAdjacency(List<List<Edge>> adjacency) {
		this.adjacency = adjacency;
	}
	
	
}
