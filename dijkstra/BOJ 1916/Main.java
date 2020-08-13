import java.io.*;
import java.util.*;

public class Main {
  private static int num_of_vertices; // Number of vertices
  private static int num_of_edges;
  private static int distance[];
  private static ArrayList<List<Node>> edges;
  private static PriorityQueue<Node> pq;
  private static int start; 
  private static int end;

  static void input() throws IOException { 
    BufferedReader br 
      = new BufferedReader(new InputStreamReader(System.in));
    num_of_vertices = Integer.parseInt(br.readLine());
    num_of_edges = Integer.parseInt(br.readLine());

    edges = new ArrayList<List<Node>>(num_of_vertices + 1);
    for (int i = 0; i <= num_of_vertices; i++)  
      edges.add(new LinkedList<Node>());

    for (int i = 0; i < num_of_edges; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int source = Integer.parseInt(st.nextToken());
      int dest = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      edges.get(source).add(new Node(dest, weight));
    }
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
    br.close();
  }

  static void init_after_input() {
    distance = new int[num_of_vertices + 1]; 
    pq = new PriorityQueue<Node>(num_of_vertices, new Node()); 
    for (int i = 1; i <= num_of_vertices; i++)
      distance[i] = 100000000;
  }

  static void dijkstra() {
    distance[start] = 0;
    pq.add(new Node(start, 0));

    while(!pq.isEmpty()) {
      Node node = pq.remove();
      int vertex = node.vertex;
      int cost = node.cost;

      if (distance[vertex] < cost)
        continue;
      Iterator<Node> it = edges.get(vertex).iterator();

      while(it.hasNext()) {
        Node linked_node = it.next();
        if(distance[linked_node.vertex] > linked_node.cost + cost) {
          distance[linked_node.vertex] = linked_node.cost + cost;
          pq.add(new Node(linked_node.vertex, linked_node.cost + cost));
        }
      }
    }
    System.out.println(distance[end]);
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
