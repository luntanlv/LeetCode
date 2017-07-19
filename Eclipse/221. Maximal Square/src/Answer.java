
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        char[][] input = new char[][]{{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}};
        //char[][] input = new char[][]{{'1','1'}};
        
        int res = answer.maximalSquare(input);
        
        System.out.println(res);     
	}
	
	
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n=0;
        if(m>0)
        	n=matrix[0].length;
        	
        int[][] dp = new int[m][n];
        int res=0;
        
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		int preLen = j>0&&i>0? dp[i-1][j-1] : 0;
        		
        		//check the new outer side
        		if(matrix[i][j] == '1'){
        			int k=1;
        			for(; k<=preLen; k++){
        				if(matrix[i-k][j]!='1' || matrix[i][j-k]!='1'){
        					break;
        				}
        			}
        			
        			dp[i][j]=k;
        		}
        		
        		res= Math.max(res, dp[i][j]*dp[i][j]);
        	}
        }
        return res; 
    }
    
    //Solution
    //better dp
    //instead of check new outer side again, we can use dp[i-1][j] and dp[i][[j-1]
    //dp[i][j]=min(dp[i-1][j], dp[i][[j-1], dp[i-1][j-1])+1
    public int maximalSquare_better(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}


