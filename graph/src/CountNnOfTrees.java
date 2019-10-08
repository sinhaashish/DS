import java.util.Iterator;
import java.util.LinkedList;

/* Given n nodes of a forest (collection of trees), find the number of trees in the forest.
Input :  edges[] = {0, 1}, {0, 2}, {3, 4}
Output : 2
Explanation : There are 2 trees
                   0       3
                  / \       \
                 1   2       4
 */

public class CountNnOfTrees {
  private int noOfVertices;
  private LinkedList<Integer> adj[];
  public CountNnOfTrees( int noOfVertices){
     this.noOfVertices = noOfVertices;
     adj = new LinkedList[noOfVertices];
     for (int i =0 ; i < noOfVertices; i++){
       adj[i] = new LinkedList<Integer>();
     }

  }

  public void addEdge( int src , int dest){
    adj[src].add(dest);
  }

  public void DFSUtil ( boolean visited[] , int n){
    visited[n] = true;
    Iterator<Integer> it = adj[n].iterator();
    while(it.hasNext()){
      int p = it.next();
      if (!visited[p]){
        DFSUtil(visited,p);
      }
    }



  }

  public int countTrees(  ){
    boolean visited[] = new boolean[noOfVertices];
    int count =0;

    for ( int i =0 ; i <  noOfVertices; i++){
      if(! visited[i]){
        DFSUtil( visited, i );
      count++;
      }
    }
    return count;

  }
  // Driver code
  public static void main(String args[])
  {
    CountNnOfTrees g = new CountNnOfTrees(5);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(3, 4);

    System.out.println(g.countTrees());
  }

}
