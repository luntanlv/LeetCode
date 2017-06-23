
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[][] input = new int[][]{{-2, -3, 3},{-5, -10, 1},{10, 30, -5}};
        int res =answer.calculateMinimumHP(input);
        System.out.println(res);       
	}

	//I saw the solution
    public int calculateMinimumHP(int[][] dungeon) {
    	int n = dungeon.length, m=0;
    	if(n>0)
    		m=dungeon[0].length;
    	
    	//store the max val(least boold)
        int[][] dp = new int[n][m];
        
        for(int i=n; i>=0; i--){
        	for(int j=m; j>=0; j--){
        		int right = i+1>=m? Integer.MAX_VALUE: dp[i+1][j];
        		int down = j+1>=n? Integer.MAX_VALUE: dp[i][j+1];
        		
        		int need = Math.min(-dungeon[i][j]+right, -dungeon[i][j]+down);
        		if(need<=0)
        			need =1;
        		dp[i][j]=need;
        	}
        }
        
        return -dp[n-1][m-1];
    }
}
