
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int res = answer.maxA(9);
        System.out.print(res);
	}
	
	//I saw the solution
	//https://leetcode.com/problems/4-keys-keyboard/description/
    public int maxA(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= i - 1; j++)
                if(i-j<3)
                    dp[i] = Math.max(dp[i], dp[j]+i-j);
                else
                    dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
        }
        return dp[n];
    }
}
