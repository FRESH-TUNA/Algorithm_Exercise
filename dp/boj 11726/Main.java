import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  private static final short MAX_LINES = 1000;
  private static int[] results = new int[MAX_LINES + 1];
  private static final int divider = 10007;
  private static int x = 1;

  private static void init() {
    results[1] = 1;
    results[2] = 2;
    results[3] = 3;
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    x = Integer.parseInt(br.readLine());
    br.close();
  }

  private static void calculateResult() {
    for(int i = 4; i <= x; ++i) 
      results[i] = (results[i - 1] + results[i - 2]) % divider; 
    System.out.println(results[x]);
  }

  public static void main(String[] args) throws IOException {
    init();
    input();
    calculateResult();
  }
}
