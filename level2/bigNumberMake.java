// class Solution {
//   public String max_calculator(String number) {
//     String max_number = number.substring(1, number.length());
//     for(int i = 0; i < number.length(); i++) {
//       String candidate = number.substring(0,i) + number.substring(i + 1, number.length());
//       if(candidate.compareTo(max_number) > 0) {
//         max_number = candidate;
//       }
//     }
//     return max_number;
//   }
//   public String solution(String number, int k) {
//     String max_number = number;
//     for(int i = 0; i < k; i++) {
//       max_number = max_calculator(max_number);
//     }
//     return max_number;
//   }
// }

import java.util.Stack;
import java.util.Iterator;
class BlgNumberMakeService {
    public int stack_check(Stack<Character> stack, Character lastst_pushed, int k){
    while(!stack.empty() && k > 0) {
      if(stack.peek() < lastst_pushed) {
        stack.pop();
        k = k - 1;
      }
      else
        break;
    }
    stack.push(lastst_pushed);
    return k;
   }
    
  public String solution(String number, int k) {
    Stack<Character> stack = new Stack<Character>();
    stack.push(number.charAt(0));
        
    for(int i = 1; i < number.length(); i++) {
        if(stack.peek() < number.charAt(i)) {
            k = stack_check(stack, number.charAt(i), k);
        }
        else {
            stack.push(number.charAt(i));
        }
    }
    StringBuilder sb = new StringBuilder();

    Iterator<Character> iterator = stack.iterator();
    while(iterator.hasNext()) {
        sb.append(iterator.next());
    }
    
    return sb.substring(0, sb.length() - k).toString();
  }
}