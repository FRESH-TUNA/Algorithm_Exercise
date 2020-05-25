import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Main {
  private static int coin_counts;
  private static int coin_sum;
  private static Treeset<Integer> coin_values;

  private static void init() {
    coin_values = new TreeSet<Integer>();
  }

  private static void input() throws IOException {
    String[] coin_information;
    BufferedReader br 
      = new BufferedReader(new InputStreamReader(System.in));
    
    coin_information = br.readLine().split(' ');
    coin_counts = String.parseInt(coin_information[0]);
    coin_sum = String.parseInt(coin_information[1]);

    for(int i = 0; i < coin_counts; ++i)
      coin_values.add(String.parseInt(br.readLine()));
    br.close();
  }

  private static void call(int value) {
    Iterator it = coin_values.iterator(); 
    int min_value = Integer.MAX_VALUE;
    // Displaying the values after iterating through the set 
    System.out.println("The iterator values are: "); 
    while (it.hasNext()) {
      int coin = it.next();
      if(value > coin) { 
        int calculated = value - coin;
        if(calculated < min_value)
          min_value = calculated;
      }
    } 
  }

  public static void main() throws IOException {

  }
}