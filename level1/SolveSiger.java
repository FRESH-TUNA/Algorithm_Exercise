import java.util.ListIterator;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class SolveSiger {
  public boolean isBlank(char obj) {
    if(obj == ' ')
      return true;
    else
      return false;
  }

  public char shiftChar(char value) {
    if(value == 'z')
      return 'a';
    else if(value == 'Z')
      return 'A';
    else
      return (char)((int)value + 1);
  }

  public String siger(String obj) {
    StringBuilder resultBuilder = new StringBuilder(obj);
    CharacterIterator iter = new StringCharacterIterator(obj);
          
    for (char value = iter.first(); value != CharacterIterator.DONE; value = iter.next()) {
      if(!this.isBlank(value))
        resultBuilder.setCharAt(iter.getIndex(), this.shiftChar(value));
    }
          
    return resultBuilder.toString();
  }

  public static void main(String[] args) {
    SolveSiger solveSiger = new SolveSiger();
    System.out.println(solveSiger.siger(args[0]));
  }
}
