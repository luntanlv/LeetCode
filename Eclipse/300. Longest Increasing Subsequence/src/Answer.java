
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{1,3,6,7,9,4,10,5,6};
        int res = answer.lengthOfLIS(input);
        System.out.print(res);
	}
	
	//O(nlogn)
	//https://discuss.leetcode.com/topic/28738/java-python-binary-search-o-nlogn-time-with-explanation
	
	//O(n^2)
    public int lengthOfLIS(int[] nums) {
    	if(nums.length==0)
    		return 0;
    	
    	int res =0;
    	//dp[i] the longest increasing subsequence ending at i
        int[] dp = new int[nums.length];
        
        for(int i =0; i<nums.length; i++){
        	//Initialize: length of itself
        	int maxEndingAtI=1;
        	for(int j=0; j<i; j++){
        		if(nums[j]<nums[i]){
        			maxEndingAtI = Math.max(maxEndingAtI, dp[j]+1);
        		}
        	}
        	dp[i]=maxEndingAtI;
        	res = Math.max(dp[i], res);
        }
        
        return res;
    }
}
