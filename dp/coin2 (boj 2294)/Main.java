import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
  private static TreeSet<Integer> coins;
  private static int wish_to_value;
  private static int[] dp;

  private static void init() {
    coins = new TreeSet<Integer>();
  }

  private static void input() throws IOException {
    String[] count_of_coin_and_wish_to_value;
    int count_of_coins;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    count_of_coin_and_wish_to_value = Integer.parseInt(br.readLine());
    count_of_coins = count_of_coin_and_wish_to_value[0];
    wish_to_value = count_of_coin_and_wish_to_value[1];
    dp = new int[wish_to_value + 1]; 

    for(int i  = 0; i < count_of_coins; ++i) 
      coins.add(Integer.parseInt(br.readLine()));
  
    br.close();
  }

  private static void calculate(int wish_to_value) {
    Iterator it = coins.iterator();
    int min_value = Integer.MAX_VALUE;

    while(it.hasNext()) {
      int value = it.next();
      if(wish_to_value >= value)
    }
  }

  private static void call() {
    for(int i = 1; i <= dp.length; ++i) 
      dp[i] = calculate_value(i);
  }

  public static void main(String[] args) throws IOException {
    init();
    input();
    call();
  }
}
