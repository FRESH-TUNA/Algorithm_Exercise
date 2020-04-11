import java.util.Scanner;

public class Main
{
    private final static int MAX_CHAR_AMOUNTS = 600000;
    private final static int MAX_COMMAND_AMOUNTS = 500000;
    
    private static int amountOfCommands;
    private static char[] line;
    private static int lineLength;
    private static String[] commands;
    private static Scanner scanner;
    
    private static void init() {
      amountOfCommands = 0;
      line = new char[MAX_CHAR_AMOUNTS];
      lineLength = 0;
      commands = new String[MAX_COMMAND_AMOUNTS];
      scanner = new Scanner(System.in);
    }
    
    private static void input() {
      getLine();
      amountOfCommands = Integer.parseInt(scanner.nextLine());
      getCommands();
      scanner.close();
    }
    
    private static void getLine() {
      char[] inputLine = scanner.nextLine().toCharArray();
      System.arraycopy(
        inputLine, 0,
        line, 0,
        inputLine.length
      );
      lineLength = inputLine.length;
    }
    
    private static void getCommands() {
      for(int i = 0; i < amountOfCommands; i++) {
        commands[i] = scanner.nextLine();
      }
    }
    
    private static void call() {
      EditorService editorService = new EditorService(
        line, lineLength, commands, amountOfCommands
      );
      editorService.call();
    }
    
    public static void main(String[] args)
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
    if(isRight)
      this.pointer += 1;
    else if(this.pointer > 0)
      this.pointer -= 1;
  }

  public void deleteChar() {
    if(this.pointer > 0) {
      System.arraycopy(
        this.line, this.pointer, 
        this.line , this.pointer - 1, 
        this.lineLength - this.pointer
      );
      --this.pointer;
    }
  }

  public void addChar(char wishToAdd) {
    System.arraycopy(
      this.line, this.pointer, 
      this.line , this.pointer + 1, 
      this.lineLength - this.pointer
    );
    this.line[this.pointer++] = wishToAdd;
  }

  public void call() {
    for(int i = 0; i < this.amountOfCommands; ++i) 
      this.execCommand(this.commands[i]);
    System.out.println(this.line);
  }
}
