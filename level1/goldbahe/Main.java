import java.util.Scanner;

class GoldbaheService {
  private Scanner scanner;
  private boolean[] sosuOrNonsosu;

  public GoldbaheService(int maxNumber) {
    this.scanner = new Scanner(System.in);
    this.sosuOrNonsosu = new boolean[maxNumber / 2 + 1];
    this.aeratostenes();
  }

  private void aeratostenes() {
    int baseSosu = 2;
    while(baseSosu <= this.sosuOrNonsosu.length - 1) {
      for(int nonSosu = baseSosu * 2; nonSosu < this.sosuOrNonsosu.length; nonSosu += baseSosu)
        this.sosuOrNonsosu[nonSosu] = true;
      baseSosu = this.findNextSmallestSosu(baseSosu);
    }
  }

  private int findNextSmallestSosu(int baseSosu) {
    baseSosu += 1;
    while(baseSosu <= this.sosuOrNonsosu.length - 1) {
      if(this.isSosu(baseSosu))
        break;
      else
        baseSosu += 1;
    }
    return baseSosu;
  }

  private boolean isSosu(int number) {
    return !this.sosuOrNonsosu[number];
  }

  private int[] calculateBiggestDifferencePair(int number) {
    int candidate = 2;

    while (candidate <= number/ 2) {
      if (this.isSosu(number - candidate)) 
        return new int[]{candidate, number - candidate};
      else 
        candidate = this.findNextSmallestSosu(candidate);
    }
    return new int[]{0, 0};
  }

  private boolean isGoldbahe(int number) {
    return number > 4 && number % 2 == 0 ? true : false;
  }

  private String makeResult(int[] pair) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(pair[0] + pair[1]);
    stringBuilder.append(" = ");
    stringBuilder.append(pair[0]);
    stringBuilder.append(" + ");
    stringBuilder.append(pair[1]);
    return stringBuilder.toString();
  }

  public void call() {
    int testNumber = 0;
    while ((testNumber = this.scanner.nextInt()) != 0) {
      if(this.isGoldbahe(testNumber)) 
        System.out.println(this.makeResult(this.calculateBiggestDifferencePair(testNumber)));
      else 
        System.out.println("Goldbach's conjecture is wrong.");
    }
    this.scanner.close();
  }
}

public class Main {
  public static void main(String[] args) {
    GoldbaheService goldbaheIterationService = new GoldbaheService(2000000);
    goldbaheIterationService.call();
  }
}
