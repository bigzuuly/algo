package main.training;

import java.util.ArrayList;
import java.util.Arrays;

public class ReversePolishNotationInPlace {

	public Integer evalRPN(String[] tokens) throws Exception {
        ArrayList<String> operators = new ArrayList<String>(Arrays.asList("+", "-", "*", "/"));
        ArrayList<String> tokensArray = new ArrayList<String>(Arrays.asList(tokens));
        
        //use in place processing to reduce the ArrayList to a single element
        int currentIndex = 0;
        while(tokensArray.size() > 1) {
        	if(operators.contains(tokensArray.get(currentIndex))){
        		//run operation
        		int b = Integer.parseInt(tokensArray.get(currentIndex-1));
        		int a = Integer.parseInt(tokensArray.get(currentIndex-2));
        		
        		String operator = tokensArray.get(currentIndex);
        		
        		//insert result
        		switch (operator) {
				
                case "+":
                	tokensArray.set(currentIndex - 2, Integer.toString(a + b));
					break;
				
				case "-":
					tokensArray.set(currentIndex - 2, Integer.toString(a - b));
					break;
					
				case "*":
					tokensArray.set(currentIndex - 2, Integer.toString(a * b));
					break;
				
				case "/":
					//check divide by 0
					if(b == 0) throw new Exception("Error: Divide by 0");
					tokensArray.set(currentIndex - 2, Integer.toString(a / b));
					break;
					
				default:
					break;
				}
        		
        		//remove elements
        		tokensArray.remove(currentIndex);
            	tokensArray.remove(currentIndex-1);
            	
        		//update currentIndex
        		currentIndex--;
        		
        	}else {
        		currentIndex++;
        	}
        }
        
        
        //continue until 1 element is left
        return Integer.valueOf(tokensArray.get(0));
    }
	
	public static void main(String[] args) throws Exception {
		ReversePolishNotationInPlace rpn = new ReversePolishNotationInPlace();
		
		System.out.println("Result: " + rpn.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
		System.out.println("Result: " + rpn.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
		System.out.println("Result: " + rpn.evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
	}
}
