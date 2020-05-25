import java.util.Scanner;

class Stack<Type> {
  class Node<Type> {
    Type data;
    Node<Type> next;

    public Node (Type data) {
      this.data = data;
      this.next = null;
    }

    public Type getData() {
      return this.data;
    }
  }

  Node<Type> head = null;
  
  public void push(Type newData) {
    Node<Type> newNode = new Node<Type>(newData);
    newNode.next = this.head;
    this.head = newNode;
  }

  public Node<Type> pop() {
    Node<Type> popedData = this.head;
    this.head = this.head.next;
    return popedData;
  }

  public Node<Type> top() {
    return this.head;
  }
} 

class StackSequenceService {
  private int[] numbers;
  private Stack<Integer> stack;
  private StringBuilder stringBuilder;

  public StackSequenceService(int[] numbers) {
    this.numbers = numbers;
    this.stack = new Stack<Integer>();
    this.stringBuilder = new StringBuilder();
  }

  /**
   * def service
   *   numbersIndex;
   *   valueWishToPush;
   *   while numbersIndex != numbers.length:
   *     if(valueWishToPush > numbers.length)
   *       return "NO"
   *     pushintoTheStack(valueWishToPush++)
   *     if valueWishToPush != stack.top():
   *       stack.pop()
   *       ++numbersIndex;
   *   reutn stringBuilder.toString();
   */
  public String call() {
    int indexOfNumbers = 0;
    int valueWishToPush = 1;

    while(indexOfNumbers != this.numbers.length) {
      if(
        this.stack.top() != null 
          && this.numbers[indexOfNumbers] == this.stack.top().getData()
      ) {
        this.stack.pop();
        ++indexOfNumbers;
        this.stringBuilder.append("-\n");
      }
      else if (valueWishToPush > numbers.length)
        return "NO";
      else {
        this.stack.push(valueWishToPush++);
        this.stringBuilder.append("+\n");
      }
    }
    return this.stringBuilder.toString();
  }
}

class Main {
  private static Scanner scanner = new Scanner(System.in); 
  private static int[] numbers;

  private static void getNumbers() {
    numbers = new int[scanner.nextInt()];
    for(int i = 0; i < numbers.length; ++i)
      numbers[i] = scanner.nextInt();
    scanner.close();
  }

  private static void call() {
    StackSequenceService stackNumberService = new StackSequenceService(numbers);
    System.out.println(stackNumberService.call());
  } 
  public static void main(String[] args) {
    getNumbers();
    call();
  }
}
