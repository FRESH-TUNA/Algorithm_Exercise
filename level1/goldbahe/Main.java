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
 
  private void aeratostenes(boolean[] numbers, int baseSosu) {
    while(baseSosu < numbers.length) {
      numbers[baseSosu] = true;
      baseSosu += baseSosu;
    }
  }

  private int findNextSmallestSosu(boolean[] numbers, int baseSosu) {
    baseSosu += 1;
    while(baseSosu <= numbers.length - 1) {
      if(numbers[baseSosu] == false)
        break;
      else
        baseSosu += 1;
    }
    return baseSosu;
  }

  private int[] calculateBiggestDifferencePair() {
    boolean[] numbers = new boolean[this.number / 2 + 1];
    int baseSosu = 2;

    while (baseSosu <= numbers.length - 1) {
      if (this.isSosu(this.number - baseSosu))
        return new int[]{baseSosu, this.number - baseSosu};
      else {
        this.aeratostenes(numbers, baseSosu);
        baseSosu = this.findNextSmallestSosu(numbers, baseSosu);
      }
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
