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

class Lcm {
  private int a, b, gcd;

  public Lcm(int a, int b, int gcd) {
    this.a = a;
    this.b = b;
    this.gcd = gcd;
  }

  public Lcm(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public int service() {
    if(this.gcd != 0)
      return this.fastLcm();
    else
      return this.slowLcm();
  }

  public int fastLcm() {
    return this.a * this.b / this.gcd;
  }

  public int slowLcm() {
    int lcm = 1;
    while(lcm % this.a == 0 && lcm % this.b == 0)
      ++lcm;
    return lcm;
  }
}

class Main{
  public static void main(String[] args) {
    int a, b;
    Scanner in = new Scanner(System.in);  // Create a Scanner object
    int gcd;
    a = in.nextInt();
    b = in.nextInt();

    Gcd gcdCalculator = new Gcd(a, b);
    Lcm lcmCalculator = new Lcm(a, b, gcd = gcdCalculator.service());
    System.out.println(gcd);
    System.out.println(lcmCalculator.service());
    in.close();
  }
}
