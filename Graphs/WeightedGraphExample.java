import java.util.Comparator;

public class WeightedGraphExample {
	public static void main(String [] args) {		
		
		WeightedGraph G = new WeightedGraph();
		System.out.print("Node: " + G.nodes[0].name + " Value: " + G.nodes[0].value + "\n");
		G.nodes[0].printConnections();
	}
}

class SortByValue implements Comparator<Node>{
	public int compare(Node a, Node b) {
		if (a.value - b.value == 0)
			return 0;
		return ((a.value - b.value > 0) ? 1:-1);
	}
}

class WeightedGraph{
	Node[] nodes;	
	char ascii;
	
	//Constructor builds a graph of ten nodes with preset connections.
	WeightedGraph(){
		nodes = new Node[10];		
		ascii = 65;	//'A'
		
		//Make some nodes and populate the array in alphabetical order.
		for (int i = 0; i < nodes.length; i++) {			
			nodes[i] = new Node(Character.toString(ascii));
			ascii++;
		}		
		
		//Edges for A.
		BuildEdge(nodes[0], nodes[1], 1);	BuildEdge(nodes[0], nodes[2], 5);	BuildEdge(nodes[0], nodes[3], 2);		
		
		//Edges for B. Note that AB has already been built.		
		BuildEdge(nodes[1], nodes[4], 2);	BuildEdge(nodes[1], nodes[5], 1);
		
		//Edges for C.
		BuildEdge(nodes[2], nodes[6], 6);
		
		//Edges for D.
		BuildEdge(nodes[3], nodes[6], 4);		
		
		//Edges for E.
		BuildEdge(nodes[4], nodes[5], 1);	BuildEdge(nodes[4], nodes[6], 2);	BuildEdge(nodes[4], nodes[8], 4);
		
		//Edges for F.
		BuildEdge(nodes[5], nodes[7], 2);
		
		//Edges for G.
		BuildEdge(nodes[6], nodes[8], 1);	BuildEdge(nodes[6], nodes[9], 5);
		
		//Edges for H.
		BuildEdge(nodes[7], nodes[8], 7);
		
		//Edges for I.
		BuildEdge(nodes[8], nodes[9], 3);		
	}
	
	//Helper function for building edges.
	private void BuildEdge(Node a, Node b, int w){
		a.neighbors[a.numEdges] = new Edge(a,b,w);
		a.numEdges++;
		b.neighbors[b.numEdges] = new Edge(b,a,w);
		b.numEdges++;
	}
}

class Node{
	String name;
	double value;	
	Edge[] neighbors;
	int numEdges = 0;
	
	Node(String n){
		name = n;
		value = Double.POSITIVE_INFINITY;
		neighbors = new Edge[10];
	}
	
	void printConnections() {
		System.out.print("Node " + this.name + " is connected to:\n");
		for(int i = 0; i < numEdges; i++) {
			if(neighbors[i] == null)
				break;
			System.out.println("Node " + neighbors[i].other.name + " " + neighbors[i].weight);			
		}
		System.out.print("\n");
	}	
}

class Edge{
	int weight;
	String name;
	Node self, other;
	
	Edge(Node a, Node b, int w){
		self = a;
		other = b;
		weight = w;
		name = a.name + b.name;		
	}
}