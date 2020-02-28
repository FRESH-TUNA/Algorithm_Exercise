import java.util.Stack;
import java.util.Iterator;
class BlgNumberMakeService {
  private String number;
  private int countOfDelete;
  private Stack<Character> stack;

  public BlgNumberMakeService(String number, int countOfDelete) {
    this.number = number;
    this.countOfDelete = countOfDelete;
    this.stack = new Stack<Character>();
  }

  public String call() {
    this.preprocessStack();
    this.bigNumberStackMake();
    return this.getBigNumber();
  }

  private void preprocessStack() {
    this.stack.push(number.charAt(0));
  }

  private void bigNumberMake() {
    for(int i = 1; i < number.length(); i++) {
      if(stack.peek() < number.charAt(i)) {
          this.stack_pop(stack, number.charAt(i));
      else 
          stack.push(number.charAt(i));
    }
  }

  private void getBigNumber() {
    Iterator<Character> iterator = stack.iterator();
    StringBuilder sb = new StringBuilder();

    while(iterator.hasNext()) {
        sb.append(iterator.next());
    }

    return sb.substring(0, sb.length() - k).toString();
  }

  private void stack_pop(Character lastst_pushed) {
    while(!this.stack.empty() && this.number > 0) {
      if(this.stack.peek() < lastst_pushed) {
        stack.pop();
        this.number--;
      }
      else
        break;
    }
    this.stack.push(lastst_pushed);
  }
}