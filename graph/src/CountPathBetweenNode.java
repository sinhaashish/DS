import afu.org.checkerframework.checker.igj.qual.I;
import java.util.Iterator;
import java.util.LinkedList;

public class CountPathBetweenNode {
  private int noOfVertices;
  private LinkedList<Integer> adj[];

  public CountPathBetweenNode(int noOfVertices){
    this.noOfVertices = noOfVertices;
    adj = new LinkedList[noOfVertices];
    for (int i =0; i< noOfVertices; i++){
      adj[i]= new LinkedList<Integer>();
    }
  }

  public void addEdge(int src, int dest){
    adj[src].add(dest);
  }

  public int countPaths(int src , int dest ){
    boolean  visited[] = new boolean[noOfVertices];
    int count =0;
    return countNoPath(src,dest,visited,count);

  }

  public int countNoPath(int src, int dest , boolean visited[] ,int pathCount){
    visited[src] =true;
    if (src == dest){
      pathCount ++;
    } else {
      Iterator<Integer> it = adj[src].iterator();
      while (it.hasNext()) {
        int p = it.next();
        if (!visited[p]) {
          pathCount=  countNoPath(p, dest, visited, pathCount);
        }
      }
    }
    visited[src] =false;
    return pathCount;

  }

  public static void main(String args[])
  {
    CountPathBetweenNode g = new CountPathBetweenNode(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(0, 3);
    g.addEdge(2, 0);
    g.addEdge(2, 1);
    g.addEdge(1, 3);

    int s = 2, d = 3;
    System.out.println(g.countPaths(s, d));
  }
}
