import java.util.Scanner;

class Gcd {
  private int a, b;

  public Gcd(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public int service() {
    return this.gcd(this.a, this.b);
  }

  public int gcd(int a, int b) {
    int remain = a % b;
    if(remain == 0)
      return b;
    else
      return this.gcd(b, remain);
  }
}

class GcdSum {
  private int[] integers;

  public GcdSum(int[] integers) {
    this.integers = integers;
  }

  public long service() {
    /**
     * 10 20 30 40
     * (10, 20) (10, 30) (10, 40) (20, 30) (20, 40) (30, 40)
     */
    long result = 0;
    for(int i = 1; i < this.integers.length; ++i){
      for(int j = i + 1; j < this.integers.length; ++j){
        Gcd gcdCalculator = new Gcd(this.integers[i], this.integers[j]);
        result += gcdCalculator.service();
      }
    }
    return result;
  }
}

class GcdSumService {
  private int caseCount;
  Scanner scanner;

  public GcdSumService(int caseCount, Scanner scanner) {
    this.caseCount = caseCount;
    this.scanner = scanner;
  }

  public void initIntegers(int[] integers, int numOfIntegers) {
    for(int i = 1; i < numOfIntegers + 1; ++i) {
      integers[i] = this.scanner.nextInt();
    }
  }

  public void call() {
    while(caseCount-- != 0) {
      int numOfIntegers = scanner.nextInt();
      int[] integers = new int[numOfIntegers + 1];
      this.initIntegers(integers, numOfIntegers);
      GcdSum gcdSum = new GcdSum(integers);
      System.out.println(gcdSum.service());
    }
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int caseCount = scanner.nextInt();

    GcdSumService gcdSumService = new GcdSumService(caseCount, scanner);

    gcdSumService.call();

    scanner.close();
  }
}
