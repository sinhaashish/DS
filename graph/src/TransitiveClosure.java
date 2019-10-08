import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TransitiveClosure {

  int noOfVertices;
  LinkedList<Integer> adj[] ;
  private int[][] tc;
  public TransitiveClosure(int noOfVertices){
    this.noOfVertices = noOfVertices;
    adj = new LinkedList[noOfVertices];
    this.tc = new int[this.noOfVertices][this.noOfVertices];
    for (int i= 0; i < noOfVertices;  i++){
      adj[i]= new LinkedList<>();
    }
  }

  public void addEdge(int src, int dest){
    adj[src].add(dest);
  }

  public void transitiveClosure() {

    // Call the recursive helper
    // function to print DFS
    // traversal starting from all
    // vertices one by one
    for (int i = 0; i < noOfVertices; i++) {
      dfsUtil(i, i);
    }
    for (int i = 0; i < noOfVertices; i++) {
      System.out.println(Arrays.toString(tc[i]));
    }
  }

    private void dfsUtil(int s, int v) {

      // Mark reachability from
      // s to v as true.
      tc[s][v] = 1;

      // Find all the vertices reachable
      // through v
      for (int ad : adj[v]) {
        if (tc[s][ad]==0) {
          dfsUtil(s, ad);
        }
      }
    }




  public static void main (String args[]){
    TransitiveClosure g = new TransitiveClosure(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    System.out.println("Transitive closure " +
      "matrix is");
    g.transitiveClosure();
  }


}
