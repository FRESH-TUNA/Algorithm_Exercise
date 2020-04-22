import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class SortByStrength implements Comparator<Turtle> { 
  public int compare(Turtle a, Turtle b) { 
    return a.strength - b.strength;
  } 
}

class Turtle {
  int weight;
  int strength;
}

public class Main {
  private static final short MAX_AMOUNTS_OF_TURTLES = 5607;
  private static Turtle[] turtles = new Turtle[MAX_AMOUNTS_OF_TURTLES];
  private static int amountOfTurtles = 0;
  
  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = null;
    while((line = br.readLine()) != null) {
      String[] splitedLine = line.split(" ");
      turtles[amountOfTurtles] = new Turtle();   
      turtles[amountOfTurtles].weight = Integer.parseInt(splitedLine[0]);
      turtles[amountOfTurtles++].strength = Integer.parseInt(splitedLine[1]);
    }
    Arrays.sort(turtles, 0, amountOfTurtles - 1, new SortByStrength());
  }

  private static void call() {
    TurtleStackService turtleStackService 
      = new TurtleStackService(turtles, amountOfTurtles);
    turtleStackService.call();
  }

  public static void main(String[] args) throws IOException {
    input();
    call();
  }
}

class TurtleStackService {
  private Turtle[] turtles;
  private int[] lis;
  private int amountOfTurtles;

  public TurtleStackService(Turtle[] turtles, int amountOfTurtles) {
    this.turtles = turtles;
    this.amountOfTurtles = amountOfTurtles;
    this.lis = new int[amountOfTurtles];
    Arrays.fill(this.lis, Integer.MAX_VALUE);
    this.lis[0] = 0;
  }

  public void call() {
    int longestSeq = 0;
    for(int i = 0; i < this.amountOfTurtles; ++i) {
      for(int j = longestSeq; j > -1; --j) {
        if(this.turtles[i].strength > this.lis[j] + this.turtles[i].weight
          && this.lis[j] + this.turtles[i].weight < this.lis[j+1]) {
            this.lis[j+1] = this.lis[j] + this.turtles[i].weight;
            longestSeq = Math.max(longestSeq, j+1);
        }
      }
    }
    System.out.println(longestSeq);
  }
}
