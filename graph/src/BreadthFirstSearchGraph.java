import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchGraph {

  private int noOfVertices;
  private LinkedList<Integer> adj[];

  BreadthFirstSearchGraph(int noOfVertices){
    this.noOfVertices= noOfVertices;
    adj = new LinkedList[noOfVertices];
    for( int i =0; i< noOfVertices; i++)
    {
      adj[i]= new LinkedList<>();
    }
  }

  public void addEdge(int v , int w){
    adj[v].add(w);
  }

  public void BFS(int s){
    boolean []visited = new boolean[noOfVertices];
    LinkedList<Integer> queue = new LinkedList<>();

    visited[s] = true;
    queue.add(s);

    while (!queue.isEmpty()){
      s = queue.poll();
      System.out.print( " --> "+ s);
      Iterator<Integer> it = adj[s].iterator();

      while(it.hasNext()){
        int n = it.next();
        if (visited[n] != true){
          queue.add(n);
          visited[n]= true;
        }
      }
    }
  }

  public static void main(String args[])
  {
    BreadthFirstSearchGraph g = new BreadthFirstSearchGraph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Following is Breadth First Traversal "+
      "(starting from vertex 2)");

    g.BFS(2);
  }







}
