package matrix;

import traversal.BFS;
import traversal.DFS;
import traversal.TravelPath;

public class Client {

	public static void main(String[] args) {
		AdjacencyMatrix matrix = new AdjacencyMatrix(13);
//		matrix.addEdge(0, 1);
//		matrix.addEdge(0, 2);
//		matrix.addEdge(2, 3);  //Example array 1, very simple.
//		matrix.addEdge(2, 4);
//		matrix.addEdge(3, 5);
//		matrix.addEdge(4, 5);
		
//		matrix.addEdge(0,1);
//		matrix.addEdge(1,2);
//		matrix.addEdge(2,3);	//Example array 2, forms a ring
//		matrix.addEdge(3, 4);
//		matrix.addEdge(0, 4);
		
		matrix.addEdge(0, 1);
		matrix.addEdge(0, 2);
		matrix.addEdge(1, 3);
		matrix.addEdge(1, 4);
		matrix.addEdge(2, 4);
		matrix.addEdge(2, 5);
		matrix.addEdge(3, 6);		//Example array 3, 11 nodes with multiple branches
		matrix.addEdge(4, 6);		//node 11 being the farthest from the start.
		matrix.addEdge(4, 7);
		matrix.addEdge(5, 7);
		matrix.addEdge(6, 8);
		matrix.addEdge(6, 9);
		matrix.addEdge(7, 9);
		matrix.addEdge(7, 10);
		matrix.addEdge(10, 11);

		
		AdjacencyMatrix matrix4 = new AdjacencyMatrix(5); // forms a net where every node is interconnected
		matrix4.setAllTrue();
		
		System.out.println(DFS.traverseTOP(0, matrix4));
		
//		matrix.print();
//		System.out.println(BFS.calculatePath(0,-1, matrix).toString());


	}

}
