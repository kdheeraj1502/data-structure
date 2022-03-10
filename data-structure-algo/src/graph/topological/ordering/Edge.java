package graph.topological.ordering;

public class Edge {

	private int dest;
	private int cost;

	public Edge(int dest, int cost) {
		this.dest = dest;
		this.cost = cost;
	}

	public int getDest() {
		return dest;
	}

	public void setDest(int dest) {
		this.dest = dest;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
