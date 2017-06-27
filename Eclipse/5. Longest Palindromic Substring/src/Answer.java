
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        //String res = answer.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        String res = answer.longestPalindrome("babad");
        System.out.println(res);    
	}
	
	//extend around center
    public String longestPalindrome(String s) {
    	int maxl=0, maxr=0;
    	int sl = s.length();
    	char[] sChr = s.toCharArray();
        for(int i=0; i<sl; i++){
            int len1 = expandAroundCenter(sChr, i, i);
            int len2 = expandAroundCenter(sChr, i, i + 1);
            int len = Math.max(len1, len2);
            if(len>maxr-maxl+1){
            	maxl = i-(len-1)/2;
            	maxr = i + len/2;
            }
        }
        return s.substring(maxl, maxr+1);
    }
    
    private int expandAroundCenter(char[] sChr, int left, int right){
    	int curL = left, curR = right;
    	while(curL>=0 && curR<sChr.length && sChr[curL]==sChr[curR]){
    		curL--;
    		curR++;
    	}
    	
    	return (curR-1)-(curL+1)+1;
    }
	
	
	//DP
    public String longestPalindrome_dp(String s) {
    	int len = s.length();
    	char[] sChr = s.toCharArray();
    	//0->not touched, 1, not palindrome, 2 palindrome
    	int[][] dp = new int[len][len];
    	int maxSubLen = 0, maxi=0, maxj=0;
    	
        for(int i=0; i<len; i++){
        	for(int j = i; j<len; j++){

        		helper(sChr, dp, i, j);
        		if(dp[i][j]==2 && j-i+1>maxSubLen){
    				maxSubLen = j-i+1;
    				maxi =i;
    				maxj=j;
        		}
        	}
        }
        return s.substring(maxi, maxj+1);
    }
    
    private void helper(char[] sChr, int[][] dp, int i, int j){
		if(dp[i][j]!=0)
			return;
    	
		if(i==j)
			dp[i][j]=2;
		else if(j==i+1)
			dp[i][j]= sChr[i]==sChr[j]? 2: 1;
		else{
			helper(sChr, dp, i+1, j-1);
			dp[i][j] = (sChr[i]==sChr[j] && dp[i+1][j-1]==2)? 2 : 1;
		}	
    }
    
    //DP better
    public String longestPalindrome_dp2(String s) {
    	  int n = s.length();
    	  String res = null;
    	    
    	  boolean[][] dp = new boolean[n][n];
    	  //This is awesome, 
    	  //OR:
    	  //for (int i = 0; i<nl i++) {
    	  //	for (int j = i; j>=0; j--) {
    	  //		......
    	  //	}
    	  //}
    	  //
    	  for (int i = n - 1; i >= 0; i--) {
    	    for (int j = i; j < n; j++) {
    	      dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
    	            
    	      if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
    	        res = s.substring(i, j + 1);
    	      }
    	    }
    	  }
    	    
    	  return res;
    }
}
