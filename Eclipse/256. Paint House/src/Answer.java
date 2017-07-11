
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[][] nums = new int[][]{{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
        int res = answer.minCost(nums);
        
        System.out.println(res);    
	}
	
	
    public int minCost(int[][] costs) {
    	//Store till last house min cost of three colors
        int[] dp = new int[3];
        
        for(int i=0; i<costs.length; i++){
        	int c0 = Math.min(dp[1], dp[2])+costs[i][0];
        	int c1 = Math.min(dp[0], dp[2])+costs[i][1];
        	int c2 = Math.min(dp[0], dp[1])+costs[i][2];
        	
        	dp[0]=c0;
        	dp[1]=c1;
        	dp[2]=c2;
        }
        return Math.min(Math.min(dp[0], dp[1]), dp[2]);
    }
}
