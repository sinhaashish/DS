import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch {

  int noOfVertices;
  LinkedList adj[];

  DepthFirstSearch(int noOfVertices){
    this.noOfVertices = noOfVertices;
    adj = new LinkedList[noOfVertices];
    for ( int i=0;i<noOfVertices; i++){
      adj[i]=new LinkedList();
    }
  }

  public void addEdge( int n , int w){
    adj[n].add(w);
  }

  public void DFSUtil(int s, boolean []visited){
    visited[s] = true;
    System.out.println(" --> "+s);

    Iterator<Integer> it = adj[s].listIterator();
    while (it.hasNext()){
      int n = it.next();
      if (!visited[n]){
        DFSUtil( n, visited);
      }
    }
  }

  public void DFS(int n){
    boolean visited[] = new  boolean[noOfVertices];
    DFSUtil(n,visited);
  }

  public static void main(String args[])
  {
    DepthFirstSearch g = new DepthFirstSearch(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Following is Depth First Traversal "+
      "(starting from vertex 2)");

    g.DFS(2);
  }

}
