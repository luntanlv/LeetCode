
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        //int[][] input = new int[][]{{-2, -3, 3},{-5, -10, 1},{10, 30, -5}};
        int[][] input = new int[][]{{-2, -3}};
        int res =answer.calculateMinimumHP(input);
        System.out.println(res);       
	}

	//second round, my solution
	//This is not right
	//https://discuss.leetcode.com/topic/52942/a-very-clean-and-intuitive-solution-with-explanation
	/*
	 * First, we need to define the subproblem somewhat a little clever. 
	 * If we define: dp[i][j] = minimum cost from (0, 0) to (i, j) 
	 * It won't help solving the problem, because the result of dp[i + 1][j + 1] does not depends only on previous solve subproblems, 
	 * but also future unsolved subproblems. 
	 * there is no way to choose up or left, if one of them need less blood to get here but it currently has less blood at this position.
	 * 
	 * So, how about let's define the subproblem from the other end of the puzzle?
	 * dp[i][j] = minimum health level required to reach the princess when entering (i, j)
	 * So, what is dp[i + 1][j + 1] then? It depends on the minimum between dp[i][j + 1] and dp[i + 1][j], because we want to choose the cheapest way to go. 
	 * Of course we also need to add or deduct the value from dungeon matrix. 
	 * But be careful, if we find that the minimum required health level is less that 0, we need to set it to 0, because we are not allowed to overdraft health. 
	 * With that said: dp[i + 1][j + 1] = max(min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i + 1][j + 1], 0);
	 * 
	 */
    public int calculateMinimumHP_notRight(int[][] dungeon) {
    	int n = dungeon.length, m=0;
    	if(n>0)
    		m=dungeon[0].length;
    	
    	//I assume 0 blood will not die, I will add 1 to result
    	//dp[i][j][0] min blood to get here(I save negative number here);  dp[i][j][1] if you start with 0 boold, num of boold at location (i,j)
    	int[][][] dp = new int[n][m][2];
    	for(int i=0; i<n; i++){
    		for(int j=0; j<m; j++){
    			if(i==0 && j==0){
    				dp[i][j][0] = dungeon[i][j];
    				dp[i][j][1] = dungeon[i][j];
    			}
    			else if(i==0){
    				dp[i][j][1] = dp[i][j-1][1] + dungeon[i][j];
    				dp[i][j][0] = Math.min(dp[i][j-1][0], dp[i][j][1]);
    			}
    			else if(j==0){
    				dp[i][j][1] = dp[i-1][j][1] + dungeon[i][j];
    				dp[i][j][0] = Math.min(dp[i-1][j][0], dp[i][j][1]);
    			}
    			else{
    				//!!!!!!there is no way to choose up or left, if one of them need less blood to get here but it currently has less blood at this position.
    				int upCurB = dp[i-1][j][1] + dungeon[i][j];
    				int upMinNeed = Math.min(dp[i-1][j][0], upCurB);
    				
    				int leftCurB = dp[i][j-1][1] + dungeon[i][j];
    				int leftMinNeed = Math.min(dp[i][j-1][0], leftCurB);
    				
    				dp[i][j][0] = Math.max(upMinNeed, leftMinNeed);
    				if(upMinNeed==leftMinNeed)
    					dp[i][j][1] =  Math.max(upCurB,leftCurB);
    				else if(dp[i][j][0]==upMinNeed)
    					dp[i][j][1] = upCurB;
    				else
    					dp[i][j][1] = leftCurB;				
    			}
    		}
    	}
    	return (dp[n-1][m-1][0]<0? -dp[n-1][m-1][0]:0) +1;
    }
	
	//I saw the solution
    public int calculateMinimumHP(int[][] dungeon) {
    	int n = dungeon.length, m=0;
    	if(n>0)
    		m=dungeon[0].length;
    	
    	//dp[i][j] store the least boold need from i,j to princess
        int[][] dp = new int[n][m];
        
        for(int i=n-1; i>=0; i--){
        	for(int j=m-1; j>=0; j--){
        		if(i+1>=n && j+1>=m)
        			dp[i][j] = -dungeon[i][j]+1;
        		else if(i+1>=n)
        			dp[i][j] = -dungeon[i][j]+dp[i][j+1];
        		else if(j+1>=m)
        			dp[i][j] = -dungeon[i][j]+dp[i+1][j];
        		else
        			dp[i][j] = -dungeon[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);

        		if(dp[i][j]<=0)
        			dp[i][j] =1;
        	}
        }
        
        return dp[0][0];
    }
}
