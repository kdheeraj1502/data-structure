package graph.dijkstra.algo;

import java.util.*;

/**
 * 
 * Single source shortest path for Direct graph, unbounded non negative weight
 * 
 * 
 * @author dheerajkumar02
 *
 */
public class DijkstraShortestPath {

	public void computePath(Vertex sourceVertex) {
		sourceVertex.setDistance(0);
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(sourceVertex);

		while (!priorityQueue.isEmpty()) {
			Vertex acualVertex = priorityQueue.poll();

			for (Edge edge : acualVertex.getNeighbors()) {
				Vertex v = edge.getTargetVertex();
				double newDistance = acualVertex.getDistance() + edge.getWeight();
				if (newDistance < v.getDistance()) {
					priorityQueue.remove(v);
					v.setDistance(newDistance);
					v.setPredecessor(acualVertex);
					priorityQueue.add(v);
				}
			}
		}
	}

	public List<Vertex> getShortestPath(Vertex target) {
		List<Vertex> shortestPath = new ArrayList<>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.getPredecessor()) {
			shortestPath.add(vertex);
		}
		Collections.reverse(shortestPath);
		return shortestPath;
	}

	public static void main(String[] args) {

		Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");

		vertex0.addNeighbor(new Edge(1, vertex0, vertex1));
		vertex0.addNeighbor(new Edge(3, vertex0, vertex2));
		vertex1.addNeighbor(new Edge(1, vertex1, vertex2));

		DijkstraShortestPath shortestPath = new DijkstraShortestPath();
		shortestPath.computePath(vertex0);

		System.out.println(shortestPath.getShortestPath(vertex2));

	}
}
