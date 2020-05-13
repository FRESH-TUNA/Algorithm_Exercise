import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
  private static final int MAX_STAIRS = 300;
  private static short[] stairs;
  private static int[] results;
  private static int stairCount;

  private static void init() {
    stairs = new short[MAX_STAIRS + 1];
    results = new int[MAX_STAIRS + 1];
    stairCount = 0;
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    stairCount = Integer.parseInt(br.readLine());
    for(int i = 1; i <= stairCount; ++i) 
      stairs[i] = (short) Integer.parseInt(br.readLine());
    br.close();
  }

  private static int calculateMaximum(int step) {
    if(results[step] != 0)
      return results[step];
    else if(step == 1) {
      results[1] = stairs[1];
      return results[1];
    }
    else if(step == 2) {
      results[2] = stairs[1] + stairs[2];
      return results[2];
    }
    else if(step == 3) {
      int a = stairs[1] + stairs[3];
      int b = stairs[2] + stairs[2];
      results[3] = Integer.max(a, b);
      return results[3];
    }
    else {
      int a = calculateMaximum(step - 2) + stairs[step];
      int b = calculateMaximum(step - 3) + stairs[step - 1] + stairs[step];
      results[step] = Integer.max(a, b);
      return results[step];
    }
  }

  private static void call() {
    System.out.println(calculateMaximum(stairCount));
  }

  public static void main(String[] args) throws IOException {
    init();
    input();
    call();
  }
}
