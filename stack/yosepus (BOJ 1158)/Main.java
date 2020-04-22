import java.util.Scanner;

class YosepuseService {
  private short[] deque;
  private short head;
  private short tail;
  private short nth;
  private short numOfElements;
  
  public YosepuseService(short[] elements, short nth, short numOfElements) {
    this.deque = elements;
    this.nth = nth;
    this.numOfElements = numOfElements;
    this.head = 0;
    this.tail = (short)(numOfElements - 1);
  }
  
  public short pop() {
    short popedValue = this.deque[this.head];
    if(this.head == deque.length - 1)
      this.head = 0;
    else
      this.head++;
    return popedValue;
  }

  public void enqueue(short value) {
    if(this.tail == deque.length - 1)
      this.tail = 0;
    else 
      this.tail++;
    this.deque[this.tail] = value;
  }

  public void nthPopAndEnqueue() {
    for(int i = 0; i < this.nth - 1; ++i) {
      short popedValue = this.pop();
      this.enqueue(popedValue);
    }
  }

  public void call() {
    StringBuilder sb = new StringBuilder();
    sb.append('<');
    while(this.numOfElements-- > 1) {
      this.nthPopAndEnqueue();
      sb.append(this.pop() + ", ");
    }
    sb.append(this.pop() + "");
    sb.append('>');
    System.out.println(sb);
  }
}

public class Main {
  private static short numOfElements;
  private static short nth;
  private static short[] elements;

  private static void input() {
    Scanner scanner = new Scanner(System.in);
    numOfElements = scanner.nextShort();
    nth = scanner.nextShort();
    elements = new short[numOfElements];
    for(short i = 0; i < numOfElements; i++) 
      elements[i] = (short)(i + 1);
    scanner.close();
  }

  private static void call() {
    YosepuseService service = new YosepuseService(elements, nth, numOfElements);
    service.call();
  }
  public static void main(String[] args) {
    input();
    call();
  }
}
