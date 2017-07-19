
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{1,2,3};
        int res = answer.combinationSum4(input,4);
        System.out.print(res);
	}
	
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i=1; i<dp.length; i++){
        	for(int j=0; j<nums.length; j++){
        		int pre = i-nums[j]<0? 0: dp[i-nums[j]];
        		dp[i] += pre;
        	}
        }
        
        return dp[target];
    }
}
