
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        //int[][] input = new int[][]{{-2, -3, 3},{-5, -10, 1},{10, 30, -5}};
        int[][] input = new int[][]{{-2, -3}};
        int res =answer.calculateMinimumHP(input);
        System.out.println(res);       
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
