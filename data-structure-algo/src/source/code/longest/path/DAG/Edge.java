package source.code.longest.path.DAG;

public class Edge {

	private Vertex target;
	private int weight;
	
	public Edge(Vertex target, int weight) {
		this.target = target;
		this.weight = weight;
	}

	public Vertex getTarget() {
		return target;
	}

	public int getWeight() {
		return weight;
	}
}
