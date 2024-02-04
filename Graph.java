
public class Graph {

	private  int NUM_VERTICES = 5;
	private Vertex[] vertices;
	private int [][] adjMatrix;

	int numVerts;

	public Graph() {
		vertices = new Vertex[NUM_VERTICES];
		adjMatrix = new int[NUM_VERTICES][NUM_VERTICES];
		numVerts = 0;
		
		for (int j = 0; j < NUM_VERTICES; j++) {
			for (int k = 0; k < NUM_VERTICES; k++) {
				adjMatrix[j][k] = 0;
			}
		}
	
	}
	private  int Check_If_Vertex_Exists(String label) {
		int vertexIndex = 0; // used for finding the vertex index
		for (Vertex vertex : vertices) {
			
			if (vertex != null)
			{if (label == vertex.Get_Label()) {
				return vertexIndex;
			}}
			vertexIndex++;
		}
		return -1; // if vertex does not exist
	}
	
	
	
	public void AddVertex(String label) {
		// if vertex does not exist
		if ( Check_If_Vertex_Exists(label) == -1)
		{
		
			vertices[numVerts] = new Vertex(label);
			numVerts++;
			System.out.println("\nVertex " + label + " has been successfully added!\n");
		}
		else {
			System.out.println("\nVertex " + label + " already exists!\n");
		}



	}
	public void RemoveVertex(String label) {
		int vertexIndex = Check_If_Vertex_Exists(label);
		if (vertexIndex > -1) {
				for (int j = 0; j < numVerts; j++) {
					for (int k  = 0; k < numVerts; k++) {
						System.out.print(numVerts);
						// Row copying / swapping
						adjMatrix[vertexIndex][k] =  adjMatrix[numVerts-1][k];
						// Column copying / swapping
						adjMatrix[j][vertexIndex] = adjMatrix[j][numVerts-1];
					}
				}
				
				vertices[vertexIndex] = vertices[numVerts - 1];
				vertices[numVerts - 1] = null;
				numVerts --;
		}
		
	}
	public void RemoveEdge(String labelA, String labelB) {
		int fromVertexIndex = Check_If_Vertex_Exists(labelA);
		int toVertexIndex = Check_If_Vertex_Exists(labelB);
		if (fromVertexIndex > -1 && toVertexIndex > -1) {
			adjMatrix[fromVertexIndex][toVertexIndex] = 0;
			adjMatrix[toVertexIndex][fromVertexIndex] = 0;
			System.out.println("Edge added successfully!");
		}
		else {
			System.out.println("Remove edge failed. Check if both Vertex exist.");
			
			
		}
	}
	
	public void AddEdge(String labelA, String labelB) {
		int fromVertexIndex = Check_If_Vertex_Exists(labelA);
		int toVertexIndex = Check_If_Vertex_Exists(labelB);
		System.out.println("Vertex from : " + labelA + "  index is : " + fromVertexIndex );
		System.out.println("Vertex from : " + labelB + "  index is : " + toVertexIndex );

		// check if both exist
		if (fromVertexIndex > -1 && toVertexIndex > -1) {
			adjMatrix[fromVertexIndex][toVertexIndex] = 1;
			adjMatrix[toVertexIndex][fromVertexIndex] = 1;
			System.out.println("Edge added successfully!");
		}
		else {
			System.out.println("Add edge failed. Check if both Vertex exist.");
			
			
		}
	}
	
	void Printgraph() {
		System.out.println("\n");
		for (int j = 0; j < numVerts; j++) {
			if (vertices[j] != null) 
				System.out.print(vertices[j].Get_Label() + "	");
		}
		System.out.println();
		
		for (int j = 0; j < numVerts; j++) {
			for (int k = 0; k < numVerts; k++) {
				System.out.print(adjMatrix[j][k] + "	");
			}
			System.out.println();
		
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Graph();
		g.AddVertex("B");
		
		g.AddVertex("C");
		g.AddVertex("D");
		g.AddEdge("B", "C");
		g.AddEdge("C", "D");
		g.AddEdge("B", "D");
		g.AddEdge("D", "D");

		g.Printgraph();
		g.RemoveVertex("C");
		g.RemoveVertex("D");
		
		g.Printgraph();
		

	}

}
