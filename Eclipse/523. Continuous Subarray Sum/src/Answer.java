import java.util.Arrays;
import java.util.HashMap;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] nums = new int[]{23, 2, 4, 6, 7,0,0};
        boolean res = answer.checkSubarraySum(nums,0);
        
        System.out.println(res);    
	}
	
    public boolean checkSubarraySum(int[] nums, int k) {
    	if(k==0){
    		int zeroCount =0;
    		for(int num: nums)
    			if(num==0)
    				zeroCount++;
    		return zeroCount>1;
    	}
    	
    	HashMap<Integer, Integer> dic = new HashMap<>();
    	//target when match
    	dic.put(0,1);
    	int sum=0;
    	for(int i=0; i<nums.length; i++){
    		sum=(sum+nums[i])%k;
    		int target = (sum-k)%k;
    		
    		if(dic.containsKey(target)&& dic.get(target)>0)
    			return true;
    		
    		dic.put(sum, dic.containsKey(sum)? dic.get(sum)+1:1);
    	}
    	return false;
    }
}
