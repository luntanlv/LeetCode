
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        String[] input = new String[]{"10","0","1"};
        int res = answer.findMaxForm(input,1,1);
        System.out.print(res);
	}
	
	//I saw the solution, 3d dp Knapsack problem
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        
        for(int i=1; i<=len; i++){
        	
        	for(int j=0; j<=m; j++){
        		
        		for(int k=0; k<=n; k++){
        			int[] count = countzeroesones(strs[i-1]);
        			int takeI=0;
        			if(j>=count[0] && k>=count[1]){
        				takeI = dp[i-1][j-count[0]][k-count[1]]+1;
        			}
        			int notTakeI = dp[i-1][j][k];
        			dp[i][j][k]=Math.max(takeI, notTakeI);
        		}
        	}
        }
        
        return dp[len][m][n];
    }
    
    //dp optimize
    public int findMaxForm_better(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }
    
    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }
    
}
