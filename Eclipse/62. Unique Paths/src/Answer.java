import java.math.BigInteger;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();        
        int res  = answer.uniquePaths(23, 12);
        System.out.println(res);
	}
	
	//DP bottom up, better, O(n)space
    public int uniquePaths(int m, int n) {
    	//store data for a row
    	int[] dp = new int[n];

    	for(int i=0; i<m; i++){
    		for(int j=0; j<n; j++){
    			if(i==0){
    				dp[j]=1;
    				continue;
    			}
    			
    			int res1 = dp[j], res2=0;
    			if(j-1>=0)
    				res2 = dp[j-1];
    			
    			dp[j]=res1+res2;
    		}
    	}
    	return dp[n-1];

    }	
	
	//DP bottom up 
    public int uniquePaths_n2space(int m, int n) {
    	int[][] dp = new int[m][n];
    	dp[0][0]=1;
    	for(int i=0; i<m; i++){
    		for(int j=0; j<n; j++){
    			if(i==0 && j==0)
    				continue;
    			
    			int res1=0, res2=0;
    			if(i-1>=0)
    				res1 = dp[i-1][j];
    			if(j-1>=0)
    				res2 = dp[i][j-1];
    			
    			dp[i][j]=res1+res2;
    		}
    	}
    	return dp[m-1][n-1];

    }
    
	
	
	
	//DP top down, back tracking with cache
    public int uniquePaths2(int m, int n) {
    	int[][] dp = new int[m][n];
    	dp[0][0]=1;
    	int[][] res =dpTopDownHelper(m-1,n-1,dp);
    	return res[m-1][n-1];

    }
    
    public int[][] dpTopDownHelper(int i, int j, int[][] dp) {
    	if(i==0 || j ==0){
    		dp[i][j]=1;
    		return dp;
    	}
    	
    	int res1 = dpTopDownHelper(i,j-1,dp)[i][j-1];
    	
    	int res2 = dpTopDownHelper(i-1,j,dp)[i-1][j];
    	
    	dp[i][j]=res1+res2;
    	
    	return dp;
    	
    }
    
	
	//math better, no BigInteger
    public int uniquePaths3(int m, int n) {
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        // here we calculate the total possible path number 
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int)res;
    }    
    
   //math
    public int uniquePaths4(int m, int n) {
    	m-=1;
    	n-=1;
    	
    	if(m==0 || n==0)
    		return 1;
    	
        //chose m from n+m
    	//(m+n)!/m!n!
    	BigInteger divisor = new BigInteger("1");
    	for(int i = m; i>1;i--)
    		divisor=divisor.multiply(new BigInteger(String.valueOf(i)));
    	
    	BigInteger dividend = new BigInteger("1");
    	for(int i = m+n; i>n;i--)
    		dividend=dividend.multiply(new BigInteger(String.valueOf(i)));
    	
    	return dividend.divide(divisor).intValue();
    }
}
