import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Name: Carson Graham
 * Date: 2019-12-10
 * Notes: pretty easy
 */
class Postfix {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {
            System.out.print("> ");
            String in = scanner.nextLine();
            if(in.isEmpty()) return;
            System.out.println("< " + toPostfix(in));
        }
    }

    private static String toPostfix(String in) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder retur = new StringBuilder();
        for(char t : in.toCharArray()){
            if(t == ' ') {
                continue;
            } else if("1234567890".contains("" + t)){
                // if t is an operand
                retur.append(t);
            } else if(t == ')') {
                while(true) {
                    char out = stack.pop();
                    if(out == '(') break;
                    retur.append(out);
                }
            } else if(t == '(') {
                stack.push(t);
            } if("+-*/".contains("" + t)) {
                while(true){
                    if(stack.isEmpty()) break;
                    if(stack.peek() == '(') break;
                    if("*/".contains("" + t) && "-+".contains("" + stack.peek())) break;

                    retur.append(stack.pop());
                }

                stack.push(t);
            }
        }
        while(!stack.isEmpty()){
            retur.append(stack.pop());
        }
        return retur.toString();
    }
}
/*
> 1 * 2 + 3
< 12*3+
> 1 + 2 * 3
< 123*+
>
 */
