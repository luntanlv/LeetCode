import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        String[] input = {"2", "1", "+", "3", "*"};
        int res = answer.evalRPN(input);
        System.out.println(res);
	}
	
    public int evalRPN(String[] tokens) {    	
    	String[] strArr = {"+", "-", "*", "/"};
    	Set<String> validOp = new HashSet<String>(Arrays.asList(strArr));
    	
    	Stack<String> st = new Stack<String>();
    	
        for(int i=0; i<tokens.length;i++){
        	if(validOp.contains(tokens[i])){
        		int num2 = Integer.parseInt(st.pop());
        		int num1 = Integer.parseInt(st.pop());
        		String op = tokens[i];
        		int res = 0;
        		switch(op){
        			case "+":
        				res = num1 + num2;
        				break;
        			case "-":
        				res = num1 - num2;
        				break;
        			case "*":
        				res = num1 * num2;
        				break;
        			case "/":
        				res = num1 / num2;
        				break;
        		}
        		st.push(Integer.toString(res));
        	}
        	else{
        		st.push(tokens[i]);
        	}
        }
        return Integer.parseInt(st.peek());
    }
}
