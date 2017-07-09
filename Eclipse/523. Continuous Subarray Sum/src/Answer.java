import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] nums = new int[]{23, 2, 4, 6, 7,0,0};
        boolean res = answer.checkSubarraySum(nums,0);
        
        System.out.println(res);    
	}
	
	//I saw the solution
	//https://leetcode.com/articles/continous-subarray-sum/
	//since we need to find out whether there is 2 elements, we need to store the index
	//And since nums are non-negative, we don't need count of sum. just need to take care of num=0, sum[i]= sum[i-1],
    public boolean checkSubarraySum(int[] nums, int k) {
    	//key sum, value: index i
    	HashMap<Integer, Integer> dic = new HashMap<>();
    	//target when match
    	dic.put(0,-1);
    	int sum=0;
    	for(int i=0; i<nums.length; i++){
    		sum=sum+nums[i];    		
    		
    		//if k=0, we cannot do %k, actually multiple of 0 is 0, so we don't need do anything
    		if(k!=0)
    			sum=sum%k;
    		
    		if(dic.containsKey(sum) && i-dic.get(sum)>1)
    			return true;
    		
    		//only happen when num=0, we keep the old index to satisfy at least 2 elements
    		if(!dic.containsKey(sum))
    			dic.put(sum, i);
    	}
    	return false;
    }
    
    //Better
    //here is really no need to use map, the required length is at least 2, so we just need to insert the mod one iteration later.
    public boolean checkSubarraySum_better(int[] nums, int k) {
    	//key sum, value: index i
    	HashSet<Integer> dic = new HashSet<>();

    	//pre =0, will insert into dic first, as a first matching num (sum of all nums till now is multiple of k)
    	int sum=0, pre=0;
    	for(int i=0; i<nums.length; i++){
    		sum=sum+nums[i];    		
    		
    		//if k=0, we cannot do %k, actually multiple of 0 is 0, so we don't need do anything
    		if(k!=0)
    			sum=sum%k;
    		
    		if(dic.contains(sum))
    			return true;
    		
    		dic.add(pre);
    		pre =sum;
    	}
    	return false;
    }
}
