import java.io.*;

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

  public Type pop() {
    Node<Type> popedData = this.head;
    this.head = this.head.next;
    return popedData.getData();
  }

  public boolean empty() {
    if(this.head == null)
      return true;
    else
      return false;
  }
} 

public class Main
{
    private final static int MAX_COMMAND_AMOUNTS = 500000;
    
    private static int amountOfCommands;
    private static Stack<Character> line;
    private static String[] commands;
    private static BufferedReader br;
    
    private static void init() {
      amountOfCommands = 0;
      line = new Stack<Character>();
      commands = new String[MAX_COMMAND_AMOUNTS];
      br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    private static void input() throws IOException {
      getLine();
      amountOfCommands = Integer.parseInt(br.readLine());
      getCommands();
      br.close();
    }
    
    private static void getLine() throws IOException {
      String inputLine = br.readLine();
      for(int i = 0; i < inputLine.length(); ++i)
        line.push(inputLine.charAt(i));
    }
    
    private static void getCommands() throws IOException {
      for(int i = 0; i < amountOfCommands; i++) {
        commands[i] = br.readLine();
      }
    }
    
    private static void call() {
      EditorStackService editorService = new EditorStackService(
        line, commands, amountOfCommands
      );
      editorService.call();
    }
    
    public static void main(String[] args) throws IOException
    {
      init();
      input();
      call();
    }
}

class EditorService {
  private char[] line;
  private int lineLength;
  private String[] commands;
  private int pointer; 
  private int amountOfCommands;
 
  public EditorService(char[] line, int lineLength, String[] commands, int amountOfCommands) {
    this.line = line;
    this.lineLength = lineLength;
    this.pointer = lineLength;
    this.commands = commands;
    this.amountOfCommands = amountOfCommands;
  }

  public void execCommand(String command) {
    switch(command.charAt(0)) {
      case 'L':
        this.moveCursor(false); break;
      case 'D':
        this.moveCursor(true); break;
      case 'B':
        this.deleteChar(); break;
      case 'P':
        this.addChar(command.charAt(2)); break;
      default:
    }
  }

  public void moveCursor(boolean isRight) {
    if(isRight && this.pointer < this.lineLength)
      this.pointer += 1;
    else if(!isRight && this.pointer > 0)
      this.pointer -= 1;
  }

  public void deleteChar() {
    if(this.pointer > 0) {
      System.arraycopy(
        this.line, this.pointer, 
        this.line , this.pointer - 1, 
        this.lineLength - this.pointer + 1
      );
      --this.lineLength;
      --this.pointer;
    }
  }

  public void addChar(char wishToAdd) {
    System.arraycopy(
      this.line, this.pointer, 
      this.line , this.pointer + 1, 
      this.lineLength - this.pointer + 1
    );
    this.line[this.pointer++] = wishToAdd;
    ++this.lineLength;
  }

  public void call() {
    for(int i = 0; i < this.amountOfCommands; ++i) 
      this.execCommand(this.commands[i]);
    System.out.println(this.line);
  }
}

class EditorStackService {
  private Stack<Character> leftStack;
  private Stack<Character> rightStack;
  private String[] commands;
  private int amountOfCommands;
 
  public EditorStackService(Stack<Character> line, String[] commands, int amountOfCommands) {
    this.leftStack = line;
    this.rightStack = new Stack<Character>();
    this.commands = commands;
    this.amountOfCommands = amountOfCommands;
  }

  public void execCommand(String command) {
    switch(command.charAt(0)) {
      case 'L':
        this.moveCursor(false); break;
      case 'D':
        this.moveCursor(true); break;
      case 'B':
        this.deleteChar(); break;
      case 'P':
        this.addChar(command.charAt(2)); break;
      default:
    }
  }

  public void moveCursor(boolean isRight) {
    if(isRight && !this.rightStack.empty())
      this.leftStack.push(this.rightStack.pop());
    else if(!isRight && !this.leftStack.empty())
      this.rightStack.push(this.leftStack.pop());
  }

  public void deleteChar() {
    if(!this.leftStack.empty())
      this.leftStack.pop();
  }

  public void addChar(char wishToAdd) {
    this.leftStack.push(wishToAdd);
  }

  public void execCommands() {
    for(int i = 0; i < this.amountOfCommands; ++i) 
      this.execCommand(this.commands[i]);
  }

  public void resultPrint() {
    StringBuilder leftResult = new StringBuilder();
    StringBuilder rightResult = new StringBuilder();
    while(!this.leftStack.empty())
      leftResult.append(this.leftStack.pop());
    while(!this.rightStack.empty())
      rightResult.append(this.rightStack.pop());
    System.out.println(leftResult.reverse().append(rightResult.toString()));
  }

  public void call() {
    this.execCommands();
    this.resultPrint();
  }
}
