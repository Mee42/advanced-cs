/*
 * Name: Carson Graham
 * Date: r!date -I
 *
 * Notes:
 *
 * Stack<T> is deprecated and is only available for backwards compatibility reasons
 * Use a Deque<T>, please. It's the same, but performance is so much better,
 * and it doesn't have `synchronize` improperly placed around the source code
 *
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class TextEditorLab {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String str;
    System.out.println("Enter an empty line to exit");
    while (true){
        System.out.print("Input String: ");
       str = input.nextLine();
       if(str.isEmpty()) break;
       System.out.println("Processed: " + process(str));
    }
    System.out.println("Thanks for ");
  }

    private static String process(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : str.toCharArray()){
            if(c == '-') { if(!stack.isEmpty()) stack.pop(); }
            else if(c == '$') stack.clear();
            else stack.push(c);
        }
        StringBuilder returnValue = new StringBuilder(stack.size());
        stack.descendingIterator().forEachRemaining(returnValue::append);
        return returnValue.toString();
    }
}
