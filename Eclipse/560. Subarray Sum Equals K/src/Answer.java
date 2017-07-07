import java.util.HashMap;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] nums = new int[]{0,0,0};
        int res = answer.subarraySum(nums,0);
        
        System.out.println(res);    
	}
	
	//I saw the solution
	
	//Using Hashingmap
	//sum[i] =  sum from 0~i, if sum[j]-sum[i]=k, mean we find one answer
	//And Use the Same idea as 1. Two sum
    public int subarraySum(int[] nums, int k) {
    	int count=0;
    	
    	HashMap<Integer, Integer> dic = new HashMap<>();
    	//used for matching curSum==k
    	dic.put(0, 1);
    	
    	int curSum=0;
    	for(int i=0; i<nums.length; i++){
    		curSum+=nums[i];
    		int target = curSum-k;
    		
    		if(dic.containsKey(target)&& dic.get(target)>0)
    			count+=dic.get(target);
    		
    		dic.put(curSum, dic.containsKey(curSum)? dic.get(curSum)+1: 1);
    	}
    	return count;
    }
	
	//Using Cummulative sum
    public int subarraySum_noSpace(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
	
    public int subarraySum_space(int[] nums, int k) {
    	int count=0;
    	//sumList[i] =  sum 0 to i;
        int[] sumList= new int[nums.length]; 
    	for(int i=0; i<nums.length; i++){

    		for(int j=i; j<nums.length; j++){
    			if(i==0){
    				sumList[j]= (j>0? sumList[j-1]: 0) +nums[j];
    			}
    			else{
    				sumList[j] = sumList[j]-sumList[i-1];
    			}
    			
    			if(sumList[j]==k)
    				count++;
    		}
    	}
    	
    	return count;
    }
    //Solution
//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        int[] sum = new int[nums.length + 1];
//        sum[0] = 0;
//        for (int i = 1; i <= nums.length; i++)
//            sum[i] = sum[i - 1] + nums[i - 1];
//        for (int start = 0; start < nums.length; start++) {
//            for (int end = start + 1; end <= nums.length; end++) {
//                if (sum[end] - sum[start] == k)
//                    count++;
//            }
//        }
//        return count;
//    }
}
