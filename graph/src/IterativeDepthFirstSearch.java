import java.util.LinkedList;
import java.util.Vector;

public class IterativeDepthFirstSearch {

  private int noOfVertices;
  private LinkedList<Integer> adj[];

  public IterativeDepthFirstSearch(int noOfVertices){
    this.noOfVertices = noOfVertices;
    adj = new LinkedList[noOfVertices];
    for (int i =0; i< noOfVertices; i++){
      adj[i]= new LinkedList<Integer>();
    }
  }

  public void addEdge(int src, int dest){
    adj[src].add(dest);
  }

  public void DFSUtil(int n, Vector<Boolean> visited){

   // boolean visited[] = new boolean[noOfVertices];
    LinkedList<Integer>  stack = new LinkedList<Integer>();
    stack.add(n);

    while (!stack.isEmpty()){
      int p = stack.peek();
      stack.poll();
      if (visited.get(p) ==false) {
       System.out.print(p +" -> ");
        visited.set(p, true);
      }

      for( int a :adj[p]){
        if (!visited.get(a)){
          stack.add(a);
        }
      }
    }
  }

  void DFS()
  {
    Vector<Boolean> visited = new Vector<Boolean>(noOfVertices);
    // Mark all the vertices as not visited
    for (int i = 0; i < noOfVertices; i++)
      visited.add(false);

    for (int i = 0; i < noOfVertices; i++)
      if (!visited.get(i)) {
        System.out.print(" ttt");
        DFSUtil(i, visited);
      }
  }


  public static void main(String args[]){
    IterativeDepthFirstSearch g = new IterativeDepthFirstSearch(5);
    g.addEdge(1, 0);
    g.addEdge(2, 1);
    g.addEdge(3, 4);
    g.addEdge(4, 0);


//    printGraph(adj);
    System.out.println("Following is the Depth First Traversal");
    g.DFS();
  }
}
