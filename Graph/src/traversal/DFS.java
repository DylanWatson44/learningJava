package traversal;

import java.util.ArrayList;
import java.util.Stack;

import matrix.AdjacencyMatrix;

public class DFS {
	
	/**This is a method for doing a Depth First Search. It utilizes a stack in order to
	 * traverse through a graph, prioritizing branches that are farthest from the 
	 * source node first. In this instance,	the bottom node is added last so it is popped
	 * first from the stack. 
	 */
	public static ArrayList<Integer> traverseBTM(int sourceNode, AdjacencyMatrix matrix){

		boolean[][] graph = matrix.getGraph(); 					//storing the matrix in a new variable so that the original is not altered.
		boolean[] alreadyVisited = new boolean[graph.length]; //extra boolean array that ensures each node is only visited once 
		Stack<Integer> stack = new Stack<Integer>(); 		//A stack is implemented for DFS so that we have a last-in, first-out system. 
		stack.add(sourceNode); 								//initialize the stack with our sourceNode so that we have a start point 
		ArrayList<Integer> traverseOrder = new ArrayList<Integer>(); //our return arraylist
		
		while (!stack.isEmpty()) {
			int visitedNode = stack.pop();				//pop the item that went on the stack last, and then set that item as the node we execute the rest of the code on
			traverseOrder.add(visitedNode);				//we also add that item to out return list. 
			//System.out.println(visitedNode);
			alreadyVisited[visitedNode] = true;			 //our boolean array is going to ensure each node is not handled more than once
			for (int j = 0; j < graph[visitedNode].length; j++) {	//for each row in the matrix of column visitedNode
				if (graph[visitedNode][j] && !alreadyVisited[j] &&!stack.contains(j)) {	//if its true (1), and its not something we've used before
					stack.add(j);														//add it to the stack to be processed at the appropriate time
				}
			}
		}
		return traverseOrder;
		//System.out.println("traverseOrder " + traverseOrder);
	}
	
/**Similar to the traverseBTM method, the traveseTOP method will add nodes to the stack in the reverse order so that
 * the top node removed from the stack first(thus, the top branches are explored first).
 */
	public static ArrayList<Integer> traverseTOP(int sourceNode, AdjacencyMatrix matrix){

		boolean[][] graph = matrix.getGraph(); 
		boolean[] alreadyVisited = new boolean[graph.length];  
		Stack<Integer> stack = new Stack<Integer>();  
		stack.add(sourceNode);  
		ArrayList<Integer> traverseOrder = new ArrayList<Integer>(); 
		
		while (!stack.isEmpty()) {
			int visitedNode = stack.pop();	
			traverseOrder.add(visitedNode);	 
			alreadyVisited[visitedNode] = true; 
			for (int j = graph[visitedNode].length-1; j >= 0 ; j--) {	//The only difference here is we start at the end of a row and work backwards
				if (graph[visitedNode][j] && !alreadyVisited[j] &&!stack.contains(j)) {	
					stack.add(j);														
				}
			}
		}
		return traverseOrder;
		//System.out.println("traverseOrder " + traverseOrder);
	}
	
	/**if you want to do a DFS that stops at a destination 
	 * NOTE: does not find the optimal path */
	public static ArrayList<Integer> traverseBTMTerm(int sourceNode, int destination, AdjacencyMatrix matrix){

		boolean[][] graph = matrix.getGraph(); 
		boolean[] alreadyVisited = new boolean[graph.length];  
		Stack<Integer> stack = new Stack<Integer>();  
		stack.add(sourceNode);  
		ArrayList<Integer> traverseOrder = new ArrayList<Integer>(); 
		
		while (!stack.isEmpty()) {
			int visitedNode = stack.pop();	
			traverseOrder.add(visitedNode); 
			if(visitedNode == destination){
				break;
			}
			//System.out.println(visitedNode);
			alreadyVisited[visitedNode] = true; 
			for (int j = 0; j < graph[visitedNode].length; j++) {	
				if (graph[visitedNode][j] && !alreadyVisited[j] &&!stack.contains(j)) {	
					stack.add(j);														
				}
			}
		}
		return traverseOrder;
		//System.out.println("traverseOrder " + traverseOrder);
	}
}
