import java.io.*;
import java.util.*;

public class Main {
  private static int num_of_vertices; // Number of vertices
  private static int num_of_edges;
  private static int distance[];
  private static int edges[][];
  private static boolean[] traced;
  private static int start; 
  private static int end; 

  static void init_arrays() {
    distance = new int[num_of_vertices + 1]; 
    traced =  new boolean[num_of_vertices + 1]; 
    edges = new int[num_of_vertices + 1][num_of_vertices + 1];
    for (int i = 1; i <= num_of_vertices; i++) {
      distance[i] = 100000000;
      for(int j = 1; j <= num_of_vertices; ++j) 
        edges[i][j] = 100000000;
    }
  }

  static void input() throws IOException { 
    BufferedReader br 
      = new BufferedReader(new InputStreamReader(System.in));
    num_of_vertices = Integer.parseInt(br.readLine());
    num_of_edges = Integer.parseInt(br.readLine());

    init_arrays();
    
    for (int i = 0; i < num_of_edges; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int source = Integer.parseInt(st.nextToken());
      int dest = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      if(edges[source][dest] > weight)
        edges[source][dest] = weight;
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
    br.close();
  }

  static int min_index() {
    int min_index = -1;
    for(int i = 1; i <= num_of_vertices; ++i) {
      if(traced[i] == false) {
        if(min_index == -1)
          min_index = i;
        else if(distance[min_index] > distance[i])
          min_index = i;
      }
    }
    return min_index;
  }

  // Function for Dijkstra's Algorithm
  static void dijkstra() {
    distance[start] = 0;
    
    for(int i = 0; i < num_of_vertices; ++i) {
      int min_index = min_index();
      traced[min_index] = true;
      
      for(int j = 1; j <= num_of_vertices; ++j) {
        if(distance[j] > distance[min_index] + edges[min_index][j])
          distance[j] = distance[min_index] + edges[min_index][j];  
      }
    }
    System.out.println(distance[end]);
  } 

  // Driver code
  public static void main(String arg[]) throws IOException {
    input();
    dijkstra();
  }
}
