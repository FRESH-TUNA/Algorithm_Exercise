import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
  private static int coin_counts;
  private static int wish;
  private static int[] dp;
  private static TreeSet<Integer> coins;

  private static void input() throws IOException {
    String[] coin_information;
    BufferedReader br 
      = new BufferedReader(new InputStreamReader(System.in));
    
    coins = new TreeSet<Integer>();
    coin_information = br.readLine().split(" ");
    coin_counts = Integer.parseInt(coin_information[0]);
    wish = Integer.parseInt(coin_information[1]);
    dp = new int[wish + 1];
    for(int i = 0; i < coin_counts; ++i)
      coins.add(Integer.parseInt(br.readLine()));
    br.close();
  }

  private static int getDp(int smallwish) {
    Iterator it = coins.iterator(); 
    int min_value = Integer.MAX_VALUE;

    if(dp[smallwish] != 0)
      return dp[smallwish];

    if(smallwish == 0)
      return 0;

    while (it.hasNext()) {
      int coin = (int) it.next();
      if(smallwish >= coin) { 
        int temp_dp = getDp(smallwish - coin);
        if(1 + temp_dp < min_value && temp_dp != Integer.MAX_VALUE) 
          min_value = 1 + temp_dp;
      }
    }
    dp[smallwish] = min_value;
    return dp[smallwish];
  }

  private static void call() {
    for(int i = 1; i <= wish; ++i)
      getDp(i);
    if(dp[wish] == Integer.MAX_VALUE)
      System.out.println(-1);
    else
      System.out.println(dp[wish]);
  }

  public static void main(String[] args) throws IOException {
    input();
    call();
  }
}
