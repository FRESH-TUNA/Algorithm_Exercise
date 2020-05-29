import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
  private static final int MAX_NUMBERS = 1000000;
  private static int[] minimums = new int[MAX_NUMBERS + 1];
  private static int number = 0;

  private static void init() {
    minimums[1] = 0;
    minimums[2] = 1;
    minimums[3] = 1;
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    number = Integer.parseInt(br.readLine());
    br.close();
  }

  private static int getMinimumOfValues(int[] array) {
    int minimum = Integer.MAX_VALUE;

    for(int value:array)
      minimum = Integer.min(minimum, value);
    return minimum;
  }

  private static int calculateMinimum(int number) {
    if(minimums[number] != 0) 
      return minimums[number];
    else {
      int devideByThree = Integer.MAX_VALUE;
      int devideByTwo = Integer.MAX_VALUE;
      int minusOne = calculateMinimum(number - 1);
    
      if(number % 3 == 0) 
        devideByThree = calculateMinimum(number / 3);
      if(number % 2 == 0)
        devideByTwo = calculateMinimum(number / 2);

      minimums[number] = 1 + getMinimumOfValues(new int[] {devideByThree, devideByTwo, minusOne});
      return minimums[number];
    }
  }

  private static void call() {
    for(int i = 4; i <= number; ++i)
      calculateMinimum(number);
    System.out.println(minimums[number]);
  }

  public static void main(String[] args) throws IOException {
    init();
    input();
    call();
  }
}
