package main.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class ReversePolishNotation {

	public Integer evalRPN(String[] tokens) throws Exception {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<String> operators = new ArrayList<String>(Arrays.asList("+", "-", "*", "/"));
        //use stack to push values from tokens
        
        //once you reach an operand in tokens
        //pop 2 values, run operation and push result
        for(int i=0; i<tokens.length; i++){
            String currentToken = tokens[i];
            if(!operators.contains(currentToken)){
                stack.push(Integer.valueOf(currentToken));
            }else{
            	Integer b;
            	Integer a;
            	
            	try {
            		b = stack.pop();
            		a = stack.pop();
            	}catch (EmptyStackException ese) {
            		throw new Exception("Error: Invalid input");
            	}
                
                switch (currentToken) {
				
                case "+":
					stack.push(a + b);
					break;
				
				case "-":
					stack.push(a - b);
					break;
					
				case "*":
					stack.push(a * b);
					break;
				
				case "/":
					//check divide by 0
					if(b == 0) throw new Exception("Error: Divide by 0");
					stack.push(a / b);
					break;
					
				default:
					break;
				}
            }
        }
        
        //continue until tokens is completely read
        return stack.pop();
    }
	
	public static void main(String[] args) throws Exception {
		ReversePolishNotation rpn = new ReversePolishNotation();
		
		System.out.println("Result: " + rpn.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
		System.out.println("Result: " + rpn.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
		System.out.println("Result: " + rpn.evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
	}
}
