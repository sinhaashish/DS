import java.util.Iterator;
import java.util.LinkedList;
// Finding the mother vertex
public class MotherVertex {

  int noOfVerticces;
  LinkedList<Integer> adj[];

  MotherVertex( int noOfVerticces){
    this.noOfVerticces= noOfVerticces;
    adj = new LinkedList[noOfVerticces];
    for (int i = 0; i< noOfVerticces; i++){
      adj[i] = new LinkedList<Integer>();
    }
  }
  public void addEdge( int n , int w){
    adj[n].add(w);
  }

  public void DFSUtil( int s,boolean []visited ) {
    visited[s] = true;

    Iterator<Integer> it = adj[s].iterator();
    while (it.hasNext()) {
      int p = it.next();
      if (!visited[p]) {
        DFSUtil(p, visited);
      }
    }
  }

  public void DFS( int n){
    boolean visited[] = new boolean[noOfVerticces];
    DFSUtil(n,visited);
  }

  public int findMOther() {
    boolean visited[] = new boolean[noOfVerticces];
    int v =0;

    for (int i =0; i< noOfVerticces; i++) {
      if (!visited[i]){
        DFSUtil(i,visited);
        v =i;
      }
    }
    boolean visit[] = new boolean[noOfVerticces];
    DFSUtil(v,visit);
    for (int i=0; i<noOfVerticces; i++)
      if (visit[i] == false)
        return -1;

    return v;


  }

  public static void main(String args[])
  {
    MotherVertex g = new MotherVertex(7);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);
    g.addEdge(4, 1);
    g.addEdge(6, 4);
    g.addEdge(5, 6);
    g.addEdge(5, 2);
    g.addEdge(6, 0);

    System.out.println(" Mother vertex is "+ g.findMOther());

  }




  }







