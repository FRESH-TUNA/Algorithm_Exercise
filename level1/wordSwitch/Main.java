import java.util.Scanner;

class Stack<Type> {
  class Node<Type> {
    Type data;
    Node<Type> next;

    public Node (Type data) {
      this.data = data;
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

class ReverseService {
  private String words;
  private StringBuilder sb;
  private Stack<Character> stack;

  public ReverseService(String words) {
    this.words = words;
    this.sb = new StringBuilder();
    this.stack = new Stack<Character>();
  }

  public void buildReverseWord() {
    while(this.stack.top() != null) sb.append(this.stack.pop().getData());
    this.sb.append(' ');
  }

  public String call() {
    for(int i = 0; i < this.words.length(); ++i) {
      if(this.words.charAt(i) == ' ') 
        this.buildReverseWord();
      else 
        stack.push(this.words.charAt(i));
    }
    this.buildReverseWord();
    return sb.toString();
  }
}

class ReverseIterationService {
  public void call() {
    Scanner scanner = new Scanner(System.in);
    int iterationCount = scanner.nextInt();
    scanner.nextLine();
    while(iterationCount-- != 0) {
      String words = scanner.nextLine();
      System.out.println(new ReverseService(words).call());
    }
    scanner.close();
  }
}

class Main {
  public static void main(String[] args) {
    new ReverseIterationService().call();
  }
}
