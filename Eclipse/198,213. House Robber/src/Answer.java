
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{5,1,2,3,4};
        int res = answer.rob(input);
        System.out.print(res);
	}
	
	//198
	//I saw the solution
	//https://leetcode.com/articles/house-robber/#approach-1-dynamic-programming-accepted
	public int rob(int[] num) {
	    int prevMax = 0;
	    int currMax = 0;
	    for (int x : num) {
	        int temp = currMax;
	        currMax = Math.max(prevMax + x, currMax);
	        prevMax = temp;
	    }
	    return currMax;
	}
	
	
	//213
	//two round of 198, 
	//first: we rob the first house, so we don't rob the last one
	//second: we don't rob the first house, so we rob the last one
    public int rob2(int[] nums) {
    	if(nums.length==0)
    		return 0;
    	else if(nums.length==1)
    		return nums[0];
    	
        //rob first house
    	int[] dp = new int[nums.length];
    	for(int i=0; i<nums.length-1; i++){
    		int pre1 = i-1>=0? dp[i-1]: 0;
    		int pre2 = i-2>=0? dp[i-2]: 0;
    		dp[i]= Math.max(pre1, pre2+nums[i]);
    	}
    	
    	int res1 = dp[nums.length-2];
    	
    	//don't rob first house
    	int pre1=0, pre2=0;
    	for(int i=1; i<nums.length; i++){
    		int cur = Math.max(pre1, pre2+nums[i]);
    		pre2 = pre1;
    		pre1 = cur;  		
    	}
    	
    	int res2 = pre1;
    	
    	return Math.max(res1, res2);
    }
}
