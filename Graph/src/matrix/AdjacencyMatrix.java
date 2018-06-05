package matrix;

public class AdjacencyMatrix {

	private boolean[][] graph;

	public AdjacencyMatrix(int size) {
		graph = new boolean[size][size];
	}

	public boolean[][] getGraph() {
		return graph;
	}

	public void addEdge(int node, int neighbor) {
		graph[node][neighbor] = true;
		graph[neighbor][node] = true;
	}
	public void setAllTrue(){
		for(int i=0;i<graph.length;i++){
			for(int j=0; j<graph[0].length;j++){
				graph[i][j]=true;
			}
		}
	}
	public void print() {
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < graph[0].length; j++) {
				if((graph[i][j]))System.out.print("1 ");
				else System.out.print("0 ");
			}
			System.out.println();
		}
	}
}
