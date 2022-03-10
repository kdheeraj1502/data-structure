package graph;

import java.util.ArrayList;
import java.util.List;

import graph.topological.Vertex;

public class CountAllPath {
	
	public static int countAllPath(List<Vertex> graph, boolean[] visited, Vertex src, Vertex des) {
		if(src == des) return 1;
		int index = Integer.valueOf(src.name);
		visited[index] = true;
		int count = 0;
		List<Vertex> edge = graph.get(index).getNeighbor();
		for(Vertex  v : edge) {
			if(!v.isVisited())
				count += countAllPath(graph, visited, v, des);
			visited[index] = false;
		}
		
		return count;
		
	}

	public static void main(String[] args) {
		List<Vertex> graph = new ArrayList<>();
		Vertex zero = new Vertex("0");
		Vertex one = new Vertex("1");
		Vertex two = new Vertex("2");
		Vertex three = new Vertex("3");
		Vertex four = new Vertex("4");
		graph.add(zero);
		graph.add(one);
		graph.add(two);
		graph.add(three);
		graph.add(four);
		
		graph.get(0).addNeighbor(graph.get(1));

		graph.get(0).addNeighbor(graph.get(2));

		graph.get(2).addNeighbor(graph.get(3));
		graph.get(1).addNeighbor(graph.get(3));

		graph.get(3).addNeighbor(graph.get(4));
		graph.get(1).addNeighbor(graph.get(4));
		boolean[] visited = new boolean[graph.size()];
		int count = countAllPath(graph, visited, zero, four);
		System.out.println(count);
	}
}
