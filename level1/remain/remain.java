import java.util.Scanner;

class Remain {
  private int a, b, c;

  public Remain(int a, int b, int c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public void service() {
    int aDividedByC = this.a % this.c;
    int bDividedByC = this.b % this.c;

    System.out.println(this.add(this.a, this.b, this.c));
    System.out.println(this.add(aDividedByC, bDividedByC, this.c));
    System.out.println(this.multiply(this.a, this.b, this.c));
    System.out.println(this.multiply(aDividedByC, bDividedByC, this.c));
  }

  private int add(int a, int b, int c) {
    return (a + b) % c;
  }

  private int multiply(int a, int b, int c) {
    return (a * b) % c;
  }
}

class Main{
  public static void main(String[] args) {
    int a, b, c;
    Scanner in = new Scanner(System.in);  // Create a Scanner object
    
    a = in.nextInt();
    b = in.nextInt();
    c = in.nextInt();

    if(!(2<=a&&a<=10000)||!(2<=b&&b<=10000)||!(2<=c&&c<=10000)) {
      System.exit(0);
    }

    Remain remain = new Remain(a, b, c);
    remain.service();
    in.close();
  }
}
