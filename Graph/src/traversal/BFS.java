package traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import matrix.AdjacencyMatrix;
/**This is a Breath First Search. It utilizes a queue to go through the nodes of an input
 *graph (boolean[][] matrix) to travel along the nodes' edges until it reaches the specified
 *location. In this case, the nodes are only represented by an integer corresponding
 *to the order in which it was inserted into the array. It the farthest point from source node
 *is desired, the function can be called with -1 as the destination. 
 */
public class BFS {
	public static Integer traverse(int sourceNode, Integer destination, AdjacencyMatrix matrix) {//

		boolean[][] graph = matrix.getGraph();
		boolean[] alreadyVisited = new boolean[graph.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(sourceNode);
		int visitedNode = 0;
		while (!queue.isEmpty()) {
			visitedNode = queue.remove();
			if (visitedNode == destination) {
				break;
			}
			// System.out.println(visitedNode);
			alreadyVisited[visitedNode] = true;
			for (int j = 0; j < graph[visitedNode].length; j++) {
				if (graph[visitedNode][j] && !alreadyVisited[j] && !queue.contains(j)) {
					if(j==destination){
						return visitedNode;
					}
					queue.add(j);
				}
			}
		}
		return visitedNode;
	}

	/** This is a method to calculate the shortest distance between two points. It utilizes
	 * the traverse method, looping that until that method returns the source node (working
	 * backwards). Every time a node just before the current destination is called as the
	 *  destination, we also add it to an array of integers, and that then is used to 
	 * construct a TravelPath object (which has the path and the number of steps stored as 
	 * fields, and a toString method). As for the complexity of this algorithm, I believe
	 * It would be N(N*M), N being the number of nodes and M being the number edges, as there
	 * two loops concerning the nodes and one for the edges within that, which simplifies to N^2.
	 */
	public static TravelPath calculatePath(int sourceNode, int destination, AdjacencyMatrix matrix) {
		TravelPath mypath = new TravelPath();
		ArrayList<Integer> mylist = new ArrayList<Integer>();
		mylist.add(destination);
		while(destination!=sourceNode){
			mylist.add(0,BFS.traverse(sourceNode, destination, matrix));
			destination=BFS.traverse(sourceNode, destination, matrix);
		}
		mypath.setCitiesVisited(mylist);
		return mypath;
	}

	
}
