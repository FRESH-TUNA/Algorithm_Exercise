import java.io.*;
import java.util.*;

public class Main {
  private static int num_of_vertices; // Number of vertices
  private static int num_of_edges;
  private static int distance[];
  private static List<List<Node>> edges;
  private static Set<Integer> traced;
  private static PriorityQueue<Node> pq;
  private static int start; 
  private static int end;

  static void input() throws IOException { 
    BufferedReader br 
      = new BufferedReader(new InputStreamReader(System.in));
    num_of_vertices = Integer.parseInt(br.readLine());
    num_of_edges = Integer.parseInt(br.readLine());

    edges = new ArrayList<List<Node>>(num_of_vertices + 1); 
    for (int i = 0; i <= num_of_vertices; i++) { 
      List<Node> item = new ArrayList<Node>(num_of_vertices + 1); 
      edges.add(item); 
    } 

    for (int i = 0; i < num_of_edges; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int source = Integer.parseInt(st.nextToken());
      int dest = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      Node temp = edges.get(source).get(dest);

      if(temp == null) {
        edges.get(source).add(
          new Node(dest, weight)
        ); 
      }
      else if(temp.cost < weight) {
        edges.get(source).set(
          source, new Node(dest, weight)
        ); 
      }
    }
    StringTokenizer st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
    br.close();
  }

  static void init_after_input() {
    distance = new int[num_of_vertices + 1]; 
    traced = new HashSet<Integer>(); 
    pq = new PriorityQueue<Node>(num_of_vertices, new Node()); 
    for (int i = 1; i <= num_of_vertices; i++)
      distance[i] = Integer.MAX_VALUE;
  }

  // Function for Dijkstra's Algorithm
  static void dijkstra() {
    distance[start] = 0;
    pq.add(new Node(start, 0));

    while (traced.size() != num_of_vertices) {
      int u = pq.remove().vertex;
      traced.add(u);
      trace_neighbors(u);
    }
    System.out.println(distance[end]);
  } 

  private static void trace_neighbors(int u) {
    for (int i = 0; i < edges.get(u).size(); i++) {
      Node v = edges.get(u).get(i);

      if (v != null && !traced.contains(v.vertex)) {
        int newDistance = distance[u] + v.cost;

        if (newDistance < distance[v.vertex])
          distance[v.vertex] = newDistance;

        pq.add(new Node(v.vertex, distance[v.vertex]));
      }
    }
  }
  // Driver code
  public static void main(String arg[]) throws IOException {
    input();
    init_after_input();
    dijkstra();
  }
}

// Class to represent a node in the graph
class Node implements Comparator<Node> {
  public int vertex;
  public int cost;

  public Node() {
  }

  public Node(int vertex, int cost) {
    this.vertex = vertex;
    this.cost = cost;
  }

  @Override
  public int compare(Node node1, Node node2) {
    if (node1.cost < node2.cost)
      return -1;
    if (node1.cost > node2.cost)
      return 1;
    return 0;
  }
}
