import java.util.LinkedList;

/* Implement Graph using Adjacency List */

public class AdjacencyList {

  int noOfVertices;
  LinkedList<Integer> adjListArray[];

   AdjacencyList(int noOfVertices){
     this.noOfVertices= noOfVertices;
    adjListArray = new LinkedList[noOfVertices];
    for (int i= 0; i <noOfVertices; i++){
      adjListArray[i] = new LinkedList<Integer>();
    }
  }

  public static void addEdge( AdjacencyList adj, int src, int dest ){
     adj.adjListArray[src].add(dest);
     // Since the graph is undirected
    // we need to add the value to both src and destination.
    adj.adjListArray[dest].add(src);
  }

  public static void printGraph(AdjacencyList adj){
     for (int i=0 ; i< adj.noOfVertices; i++){
       System.out.println("Adjacency list of Vertex " + i);
       System.out.print(" Head");
       for( Integer t : adj.adjListArray[i]){
         System.out.print(" --> " +t);
       }
       System.out.println("\n");
     }
  }

  // Driver program to test above functions
  public static void main(String args[])
  {
    // create the graph given in above figure
    int V = 5;
    AdjacencyList graph = new AdjacencyList(V);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 4);
    addEdge(graph, 1, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 1, 4);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 4);

    // print the adjacency list representation of
    // the above graph
    printGraph(graph);
  }




}
