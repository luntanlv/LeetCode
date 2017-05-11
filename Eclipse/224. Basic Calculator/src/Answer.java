import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        String input = "1-((1+1))";
        
        int res = answer.calculate(input);
        System.out.println(res);
	}
	
    public int calculate(String s) {
    	Stack<Integer> numSt = new Stack<Integer>();
    	Stack<Character> opSt = new Stack<Character>();
    	
    	int tempNum=0;
    	boolean getNum = false;
        for(int i=0; i<s.length(); i++){
        	char cur = s.charAt(i);
        	
			if((cur<'0' || cur>'9') && getNum){
				//no pending op right now
				if(opSt.isEmpty() || opSt.peek() == '(')
					numSt.push(tempNum);
				// pending op can be done right now
				else{
		    		char pendingOp = opSt.pop();
		    		int num = numSt.pop();
		    		switch(pendingOp){
		    			case '+':
		    				numSt.push(num+tempNum);
		    				break;
		    			case '-':
		    				numSt.push(num-tempNum);
		    				break;
		    		}   
				}
				tempNum = 0;
				getNum=false;
			}
			
			if(cur>='0' && cur<='9'){
				getNum = true;
				tempNum=tempNum*10+cur-'0';
			}  	        	
        	
			else if(cur == '('){
				opSt.push('(');
        	}
        	else if(cur ==')'){    		
        		//pop '('
        		opSt.pop();
        		//get previous pending op (op before '(')
        		if(!opSt.isEmpty() && opSt.peek() != '('){
    	    		char pendingOp = opSt.pop();
    	    		int num1 = numSt.pop();
    	    		int num2 = numSt.pop();
    	    		switch(pendingOp){
    	    			case '+':
    	    				numSt.push(num1+num2);
    	    				break;
    	    			case '-':
    	    				numSt.push(num2-num1);
    	    				break;
    	    		}         			
        		}
  
			}
        	else if(cur =='+' || cur =='-')
        		opSt.push(cur);
        	else
        		continue;
        }
        
        if(getNum){
        	numSt.push(tempNum);
        	if(!opSt.isEmpty()){
	    		char pendingOp = opSt.pop();
	    		int num1 = numSt.pop();
	    		int num2 = numSt.pop();
	    		switch(pendingOp){
	    			case '+':
	    				numSt.push(num1+num2);
	    				break;
	    			case '-':
	    				numSt.push(num2-num1);
	    				break;
	    		}         		
        	}
        	
        }     	
        
        return numSt.pop();
    }	
	
	
	
    public int calculate2(String s) {
    	Stack<String> tempRes = new Stack<String>();
    	tempRes.push("");

        for(int i=0; i<s.length(); i++){
        	char cur = s.charAt(i);
        	
        	if(cur == '('){
        		tempRes.push("");
        	}
        	else if(cur ==')'){
        		String basicSubStr = tempRes.pop();
        		int subRes = getBasicCal(basicSubStr);
        		//very hard to handle negtive result as String
        		String lastStr = tempRes.pop();
        		if(subRes<0){
        			char lastChar;
        			if(lastStr.length()>0){
        				lastChar = lastStr.charAt(lastStr.length()-1);
                		if(lastChar == '+')
                			lastStr=lastStr.substring(0, lastStr.length()-1);
                		else if(lastChar == '-'){
                			lastStr=lastStr.substring(0, lastStr.length()-1);
                			lastStr+="+";
                			subRes=-subRes;
                		}
                		else{
                			lastStr=lastStr.substring(0, lastStr.length()-1);
                			lastStr+="0";
                		}        				
        			}
        			else
        				lastStr="0";
        		}
  		
        		String newSubRes = lastStr + Integer.toString(subRes);
        		tempRes.push(newSubRes);
        	}
        	else if(cur ==' ')
        		continue;
        	else{
        		tempRes.push(tempRes.pop()+cur);
        	}
        }
        
        return getBasicCal(tempRes.pop());
    }
    
    //calculate basic string with no parenthesis
    private int getBasicCal(String s){
    	LinkedList<Integer> numQ = new LinkedList<Integer>();
    	Queue<Character> opQ = new LinkedList<Character>();
    	
    	int tempNum=0;
    	boolean getNum = false;
		for(int i=0; i<s.length(); i++){
			char cur = s.charAt(i);
			
			if((cur<'0' || cur>'9') && getNum){
				numQ.add(tempNum);
				tempNum = 0;
				getNum=false;
			}
			
			if(cur>='0' && cur<='9'){
				getNum = true;
				tempNum=tempNum*10+cur-'0';
			}  	
			else if(cur == ' '){
				continue;
			}
			
			else if(cur == '+' || cur =='-'){
				opQ.add(cur);
			}
		} 
		
		if(getNum)
			numQ.add(tempNum);
    	
        while(!opQ.isEmpty()){
    		char curOp = opQ.poll();
    		int num1 = numQ.poll();
    		int num2 = numQ.poll();
    		switch(curOp){
    			case '+':
    				numQ.add(0, num1+num2);
    				break;
    			case '-':
    				numQ.add(0, num1-num2);
    				break;
    		}        	
        }
        
        return numQ.poll();
    }
    
}
