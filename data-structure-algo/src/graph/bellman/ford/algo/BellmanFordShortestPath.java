package graph.bellman.ford.algo;

/**
 * 
 * for{v0 v1, v2, v3...} all nodes G(V, E):  			 O(V)
 * 
	 * for each node edge(u, v) with weight in edge
	 * 
	 * dist = distance[u] + w								O(E) * O(1)
	 * if(dist < distace[v])
	 * 	distance[v] = dist
	 *  predecessor[v] = u
 *  
 *for each edge (u, v) with weight w in edge
 *	if distance[u] + w < distance[v]						O(E)
 *		error:, negative cycle detected
 * 
 * 
 * O(V) * [O(E) * O(1)] + O(E) = O(V) * O(E) + O(E) = O(V * E) + O(E) = O(V * E)
 * 
 * @author dheerajkumar02
 *
 */
public class BellmanFordShortestPath {

}
