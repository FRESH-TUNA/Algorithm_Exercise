import java.util.LinkedList;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
  static LinkedList<Character> stack;
  static String line;

  static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    line = br.readLine();
    br.close();
  }

  static int getNumOfPipes() {    
    LinkedList<Character> stack 
      = new LinkedList<Character>();;
    int numOfPipes = 0;
    char lastCharacter = ' ';

    for(int i = 0; i < line.length(); ++i) {
      if(line.charAt(i) == '(') 
        stack.push('(');
      else if(lastCharacter == ')') { 
        stack.pop();
        numOfPipes += 1;
      }
      else {
        stack.pop();
        if(stack.size() > 0)
          numOfPipes += stack.size();
      }
      lastCharacter = line.charAt(i);
    }

    return numOfPipes;
  }

  static void call() {
    System.out.println(getNumOfPipes());
  }

  public static void main(String[] args) throws IOException {
    input();
    call();
  }
}
