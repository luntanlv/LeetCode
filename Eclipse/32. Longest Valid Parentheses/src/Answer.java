import java.util.List;
import java.util.Stack;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int res = answer.longestValidParentheses(")()())");
        System.out.println(res);       
	}
	
	//I saw the solution
	//DP
    public int longestValidParentheses_dp(String s) {
    	char[] sChr = s.toCharArray();
    	//dp[i] The longest valid parentheses ending in i 
    	int[] dp = new int[sChr.length];
    	
    	for(int i=0; i<sChr.length; i++){
    		if(sChr[i]=='('){
    			dp[i] = 0;
    		}
    		//sChr[i]==')'
    		else{
    			//()
    			if(i-1>=0 && sChr[i-1]=='(')
    			{
        			dp[i]=(i-2>0? dp[i-2]:0) + 2;
        		}
    			//))
    			else if(i-1>=0 && sChr[i-1]==')' && dp[i-1]>0 && i-dp[i-1]-1>=0 && sChr[i-dp[i-1]-1]=='('){
    				int pre = i-dp[i-1]-2>=0? dp[i-dp[i-1]-2]:0;
    				dp[i]=dp[i-1]+2+pre;
    			}
    		}		
    	}
    	
    	int res=0;
    	for(int val: dp){
    		res=Math.max(res, val);
    	}
    	return res;
    }
    
    //JD's solution
    //Stack1
    public int longestValidParentheses(String s) {
        Stack<Character> charSt = new Stack<>();
        Stack<Integer> indexSt = new Stack<>();
        //Starting point
        indexSt.push(-1);
        
        char[] sChr = s.toCharArray();
        int res=0;
        for(int i=0; i<sChr.length; i++){
        	//got a valid pair
        	if(!charSt.isEmpty() && charSt.peek()=='(' && sChr[i]==')'){
        		charSt.pop();
        		indexSt.pop();
        	}
        	else{
        		charSt.push(sChr[i]);
        		indexSt.push(i);
        	}
        	
        }
        
        //what's left in the stack is invalid character and its index
        //so the valid length is between these index
        int end = sChr.length;
        while(!indexSt.isEmpty()){
        	int start = indexSt.pop();
        	int len = end-start-1;
        	res = Math.max(res, len);
        	end = start;
        }
        
        return res;
    }
    
    //Stack2
    //I saw the slolution
    public int longestValidParentheses_st2(String s) {
    int maxans = 0;
    Stack<Integer> stack = new Stack<>();
    //need last invalid index to caluclute the length since last invalid
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            stack.push(i);
        } else {
            stack.pop();
            if (stack.empty()) {
                //need last invalid index to caluclute the length since last invalid, pust i as last invalid index
                    //For eample, )()())£¬ need to push 0 as last invalid index, so we can get valid length by 4-0=4
                stack.push(i);
            } else {
                maxans = Math.max(maxans, i - stack.peek());
            }
        }
    }
        return maxans;
    }
    
    //I saw the solution
    //Two scan, left and right
    public int longestValidParentheses_lr(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
    
}
