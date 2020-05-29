import java.util.Scanner;

class SosuService {
  private short number;

  public SosuService(short number) {
    this.number = number;
  }

  public boolean call() {
    if(this.number == 1)
      return false;
    else {
      for(int numberInRange = 2; numberInRange < this.number; ++numberInRange)
        if(this.number % numberInRange == 0) return false;
    }
    return true;
  }
}

class SosuCountService {
  private byte iterationCount;
  private Scanner scanner;

  public SosuCountService(byte iterationCount, Scanner scanner) {
    this.iterationCount = iterationCount;
    this.scanner = scanner;
  }

  public byte call() {
    byte sosuCount = 0;

    while(iterationCount-- != 0) {
      short testNumber = scanner.nextShort();
      SosuService sosuService = new SosuService(testNumber);
      if(sosuService.call()) ++sosuCount;
    }

    return sosuCount;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    byte iterationCount = scanner.nextByte();
    SosuCountService sosuCountService = 
      new SosuCountService(iterationCount, scanner);
    System.out.println(sosuCountService.call());
    scanner.close();
  }
}
