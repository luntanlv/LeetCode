import java.util.List;
import java.util.Stack;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int res = answer.longestValidParentheses("()(())");
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
    
    //I saw the solution
    //Stack
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        char[] sChr = s.toCharArray();
        int res=0;
        for(int i=0; i<sChr.length; i++){
        	if(sChr[i]=='(')
        		st.push(i);
        	//)
        	else{
        		if(!st.isEmpty()){
        			cur=0;
        		}
        			
        	}
        	res = Math.max(res, cur);
        }
        return res;
    }
}
