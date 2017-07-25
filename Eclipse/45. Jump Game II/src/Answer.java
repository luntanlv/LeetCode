
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{2,3,1,1,4};
        int res = answer.jump(input);
        //boolean res = answer.search81(input,8);
        System.out.println(res);    
	}
	
	//I saw the solution
	//Gready, dp
    public int jump(int[] nums) {
    	//the max index can reach before next jump
    	int nextMaxReach = 0;
    	int curJumpEnd = 0;
    	int jump=0;
    	
    	for(int i=0; i<nums.length-1; i++){
    		nextMaxReach = Math.max(nextMaxReach, nums[i]+i);
    		
    		if(nextMaxReach>=nums.length-1){
    			jump++;
    			break;
    		}   			
    		else if(nextMaxReach==i){
    			return -1;
    		}
    		
    		if(i==curJumpEnd){
    			jump++;
    			curJumpEnd = nextMaxReach;
    		}
    	}
    	return jump;	
    }
	
	//Time Limit Exceeded
    //dp
    public int jump_n2(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length; i++){
        	dp[i]=Integer.MAX_VALUE;
        }
        dp[0]=0;
        
        for(int i=0; i<nums.length-1; i++){
        	for(int j=1; j<=nums[i]; j++){
        		if(i+j<nums.length)
        			dp[i+j]=Math.min(dp[i+j], dp[i]+1);
        	}
        }
        
        return dp[nums.length-1];
    }
}
