
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();        
        int res  = answer.minPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        System.out.println(res);
	}
	
	//DP bottom up, better, O(n)space
    public int minPathSum(int[][] grid) {
    	int m = grid.length, n=0;
    	if(m>0)
    		n=grid[0].length;
    	if(m ==0 || n==0)
    		return 0;
    	
    	//store data for a row
    	int[] dp = new int[n];
    	dp[0]=grid[0][0];
    	for(int j=1; j<n; j++){
    		dp[j]=dp[j-1]+grid[0][j];
    	}

    	for(int i=1; i<m; i++){
    		for(int j=0; j<n; j++){
    			if(j==0)
    				dp[j] = dp[j]+grid[i][j];
    			else
    				dp[j] = Math.min(dp[j-1], dp[j])+grid[i][j];

    		}
    	}
    	return dp[n-1];
    }	
}
