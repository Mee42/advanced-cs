import java.util.Scanner;
import java.util.Stack;

class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(true){
			System.out.print(">> ");
			String in = s.nextLine();
			if(in.equals("")) break;
			System.out.println(toPostfix(in));
		}
	}

	private static String toPostfix(String in){
		Stack<Character> opStack = new Stack<Character>();
		StringBuilder retur = new StringBuilder();
		for(char c : in.toCharArray()){
			if("0123456789".contains("" + c)){
				retur.append(c);	
			} else if(c == ')'){
				while(opStack.peek() != '('){
					retur.append(opStack.pop());
				}
				opStack.pop(); // pop the (
			} else if(c == '('){
				opStack.push('(');
			} else {
				while(!opStack.isEmpty()
					&& ((c == '+' || c == '-') &&
					   (opStack.peek() =='/'||opStack.peek()=='*')) 
		 		        && opStack.peek() != '('){
					retur.append(opStack.pop());
				}
				opStack.push(c);
			}
			
		}
		while(!opStack.isEmpty()) retur.append(opStack.pop());
		return retur.toString();			
		
	}

	

}
