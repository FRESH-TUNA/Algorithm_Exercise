import java.util.Scanner;

class GoldbaheService {
  private int number;

  public GoldbaheService(int number) {
    this.number = number;
  }

  private boolean isSosu(int number) {
    if (number == 1)
      return false;
    else {
      for (int numberInRange = 2; numberInRange < number; ++numberInRange)
        if (number % numberInRange == 0)
          return false;
    }
    return true;
  }

  private int[] calculateBiggestDifferencePair() {
    int[] pair = new int[] {2, this.number - 2};
    while (pair[0] <= pair[1]) {
      if (this.isSosu(pair[0]) && this.isSosu(pair[1]))
        return pair;
      else
        pair[0] += 1; pair[1] -= 1;
    }
    return new int[]{0, 0};
  }

  private boolean isGoldbahe() {
    return this.number > 4 && this.number % 2 == 0 ? true : false;
  }

  private String makeResult(int[] pair) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.number);
    stringBuilder.append(" = ");
    stringBuilder.append(pair[0]);
    stringBuilder.append(" + ");
    stringBuilder.append(pair[1]);
    return stringBuilder.toString();
  }

  public String call() {
    if(this.isGoldbahe()) 
      return this.makeResult(this.calculateBiggestDifferencePair());
    else 
      return "Goldbach's conjecture is wrong.";
  }
}

class GoldbaheIterationService {
  private Scanner scanner;

  public GoldbaheIterationService() {
    this.scanner = new Scanner(System.in);
  }

  public void call() {
    int testNumber = 0;
    while ((testNumber = this.scanner.nextInt()) != 0) {
      GoldbaheService goldbaheService = new GoldbaheService(testNumber);
      System.out.println(goldbaheService.call());
    }
    this.scanner.close();
  }
}

public class Main {
  public static void main(String[] args) {
    GoldbaheIterationService goldbaheIterationService = new GoldbaheIterationService();
    goldbaheIterationService.call();
  }
}
