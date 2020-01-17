import java.util.Stack;

/**
 * Name: Carson
 *
 * Notes: pretty easy alternate version of the infix - to - prefix lab, so nothing too difficult.
 * StringBuilder seems to be the best class for putting together the string, because
 * you can allocate exactly how many chars you need and not have any runtime memory issues.
 *
 * There's really two ways to pick how much memory to allocate.
 * You can, either, allocate more then you need (the length of the string) but you'll have another
 * pair of bytes in memory taken up during runtime for every parentheses pair.
 * The other option is to count the number of non-parentheses - which takes an O(n) call but might save memory in the long run
 * I've done the latter, for fun
 *
 * Of course, you can't use Stack<Character> and say you care about performance and memory usage.
 * so, whatever, I guess
 *
 */
public class InfixToPostfix {
  public static void main(String[] args) {
      System.out.println(toPostfix("1+2"));
      System.out.println(toPostfix("1+2*3"));
      System.out.println(toPostfix("(1+2)*3"));
  }

    private static String toPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '+' || c == '-') {
                while(!stack.isEmpty()) {
                    char top = stack.pop();
                    if(top == '('){
                        stack.push('(');
                        break;
                    } else {
                        out.append(top);
                    }
                }
                stack.push(c);
            } else if(c == '*' || c == '/') {
                while(!stack.isEmpty()) {
                    char top = stack.pop();
                    if(top == '('){
                        stack.push('(');
                        break;
                    } else {
                        if (top == '+' || top == '-') {
                            stack.push(top);
                            break;
                        } else {
                            out.append(top);
                        }
                    }
                }
                stack.push(c);
            } else if(c == '(') {
                stack.push('(');
            } else if(c == ')') {
                while(!stack.isEmpty()){
                    char top = stack.pop();
                    if(top == '(') break;
                    out.append(top);
                }
            } else {
                out.append(c);
            }
        }
        while(!stack.isEmpty()) {
            out.append(stack.pop());
        }
        return out.toString();

    }
}
