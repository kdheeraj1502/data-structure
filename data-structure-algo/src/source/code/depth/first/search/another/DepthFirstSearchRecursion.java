package source.code.depth.first.search.another;

import java.util.List;

public class DepthFirstSearchRecursion {
	
	public void dfs(List<Vertex> vertexList) {
		
		// it may happen that we have independent clusters
		for(Vertex v : vertexList) {
			if(!v.isVisited()) {
				v.setVisited(true);
				dfsHelper(v);
			}
		}			
	}

	private void dfsHelper(Vertex vertex) {
		
		System.out.println(vertex);
		
		for(Vertex v : vertex.getNeighbors()) {
			if(!v.isVisited()) {
				v.setVisited(true);
				dfsHelper(v);
			}
		}	
	}
}










