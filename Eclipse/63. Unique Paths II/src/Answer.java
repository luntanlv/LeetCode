
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();        
        int res  = answer.uniquePaths(23, 12);
        System.out.println(res);
	}
	
	//DP bottom up, better, O(n)space
    public int uniquePaths(int[][] obstacleGrid) {
    	int m = obstacleGrid.length, n=0;
    	if(m>0)
    		n=obstacleGrid[0].length;
    	if(m ==0 || n==0)
    		return 0;
    	
    	//store data for a row
    	int[] dp = new int[n];
    	dp[0]=1;

    	for(int i=0; i<m; i++){
    		for(int j=0; j<n; j++){			
    			if(obstacleGrid[i][j]==1){
    				dp[j] =0;
    				continue;
    			}
    			
    			if(i==0 && j==0)
    				continue;    			
    			else if(i==0 && j>0){
    				dp[j]=dp[j-1];
    				continue;
    			}
    						
    			if(j>0)
    				dp[j] += dp[j-1];

    		}
    	}
    	return dp[n-1];

    }	
}
