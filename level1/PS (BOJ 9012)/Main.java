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

class PSService {
  private String line;
  private Stack<Character> stack;

  public PSService(String line) {
    this.line = line;
    this.stack = new Stack<Character>();
  }

  public String call() {
    for(int i = 0; i < this.line.length(); ++i) {
      if(this.line.charAt(i) == '(')
        this.stack.push('(');
      else if(this.stack.top() == null)
        return "NO";
      else 
        this.stack.pop();
    }
    return (this.stack.top() == null) ? "YES" : "NO";
  }
}

class Main {
  private static Scanner scanner = new Scanner(System.in); 
  private static int iterationCount;

  private static void getIterationCount() {
    iterationCount = scanner.nextInt();
    scanner.nextLine();
  }

  private static void iterationServiceCall() {
    while(iterationCount-- != 0) {
      String line = scanner.nextLine();
      PSService service = new PSService(line.substring(0, line.length()));
      System.out.println(service.call());
    }
  } 
  public static void main(String[] args) {
    getIterationCount();
    iterationServiceCall();
  }
}
