package graph;

public class Edge {

	private int des;
	private int cost;
	
	public Edge(){}
	
	public Edge(int des, int cost){
		this.des = des;
		this.cost = cost;
	}

	public int getDes() {
		return des;
	}

	public void setDes(int des) {
		this.des = des;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
