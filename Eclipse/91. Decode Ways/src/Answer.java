import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int res = answer.numDecodings("1206");
        System.out.println(res);       
	}
	
	//Just ask how many ways, so dp, Backtracking is over kill
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        
        //dp[i]: Num of ways for s.substring(0, i)
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
	
    public int numDecodingsWithDataSet(String s) {
    	List<String> res = new ArrayList<String>();
    	StringBuilder cur = new StringBuilder();
    	
    	helper(res, cur, 0, s);
    	
    	for(String str : res)
    		 System.out.println(str);
    	
    	return res.size();
    }
    
    private void helper(List<String> res,StringBuilder cur, int index, String s){
    	if(index >=s.length()){
    		if(cur.length()>0)
    			res.add(cur.toString());
    		return;  		
    	}	
    	
    	int singleNum =  s.charAt(index)-'0';
    	if(singleNum != 0){     	      	
        	char singleNumChar = (char)('A' + singleNum -1);
        	cur.append(singleNumChar);
        	helper(res, cur, index+1, s);
        	cur.deleteCharAt(cur.length()-1);    		
    	}
    	else
    		return;

    	if(index+1<s.length()){
    		int twoDigNum = singleNum*10 + s.charAt(index+1)-'0';
    		
    		if(twoDigNum<=26){
        		char twoDigNumChar = (char)('A' + twoDigNum -1);
        		cur.append(twoDigNumChar);
            	helper(res, cur, index+2, s);
            	cur.deleteCharAt(cur.length()-1);   			
    		}
    	}
    }
}
