import java.io.*;
import java.util.*;

class BellmanFord {
  private int num_of_vertices; // Number of vertices
  private int[] distance;
  private boolean minusCycle;
  private List<Node>[] edges;

  public BellmanFord(int num_of_vertices,  List<Node>[] edges, int start) {
    this.edges = edges;
    this.num_of_vertices = num_of_vertices;
    this.distance = new int[num_of_vertices + 1];
    this.minusCycle = false;

    for(int i = 0; i < this.distance.length; ++i)
      distance[i] = Short.MAX_VALUE;
    distance[start] = 0;
  }

  public void print() {
    if(this.minusCycle)
      System.out.println(-1);
    else {
      for(int i = 2; i <= this.num_of_vertices; ++i) {
        if(distance[i] == Short.MAX_VALUE)
          System.out.println(-1);
        else
          System.out.println(distance[i]);
      }
    }
  }

  public void call() {
    for(int i = 1; i <= this.num_of_vertices; ++i) 
      trace(i);
    has_nagative_cycle();
    print();
  }

  public void trace(int node) {
    Iterator it = edges[node].iterator();
    while(it.hasNext()) {
      Node temp = (Node) it.next();
      if(
        distance[node] != Short.MAX_VALUE
        && distance[node] + temp.cost < distance[temp.vertex]
      ) 
        distance[temp.vertex] = distance[node] + temp.cost;
    }
  }

  public void has_nagative_cycle() {
    for(int i = 1; i <= this.num_of_vertices; ++i) {
      Iterator it = edges[i].iterator();
      while(it.hasNext()) {
        Node temp = (Node) it.next();
        if(
          distance[i] != Short.MAX_VALUE
          && distance[temp.vertex] > distance[i] + temp.cost
        ) {
          minusCycle = true;
          break;
        }
      }
    }
  }
}

class Node{
  public int vertex;
  public int cost;

  public Node() {
  }

  public Node(int vertex, int cost) {
    this.vertex = vertex;
    this.cost = cost;
  }
}

public class Main {
  private static int num_of_vertices; // Number of vertices
  private static int num_of_edges; // Number of vertices
  private static List<Node>[] edges;

  private static void call() {
    BellmanFord bf = new BellmanFord(num_of_vertices, edges, 1);
    bf.call();
  }

  private static void input() throws IOException{
    BufferedReader br 
      = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer sb = new StringTokenizer(br.readLine());

    num_of_vertices = Integer.parseInt(sb.nextToken());
    num_of_edges = Integer.parseInt(sb.nextToken());
    edges = new List[num_of_vertices + 1];

    for(int i = 0; i <= num_of_vertices; ++i)
      edges[i] = new LinkedList<Node>();

    for(int i = 0; i < num_of_edges; ++i) {
      sb = new StringTokenizer(br.readLine());
      edges[Integer.parseInt(sb.nextToken())].add(
        new Node(Integer.parseInt(sb.nextToken()), Integer.parseInt(sb.nextToken()))
      );
    }
    br.close();
  }

  public static void main(String[] args) throws IOException{
    input();
    call();
  }
}
