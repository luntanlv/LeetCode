import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int[] input = new int[]{-2,0,1,1,2};
        List<List<Integer>> res = answer.threeSum(input);
        System.out.println(res);       
	}
	
	//15
	//Sort and use two pointer, so we can control the number we select (move l or r pointer) based on comparison to target. so we eliminate one loop. from n^3 to n^2
	//For two sum, we can also sort and use pointer, but sort will take O(nlogn), so it is better to use hashmap to get O(n) 
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> resList = new ArrayList<>();
    	Arrays.sort(nums);
    	for(int i=0; i<nums.length-2;i++){
    		if(i>0 && nums[i]==nums[i-1])
    			continue;
    		int l=i+1, r= nums.length-1;
    		int target = - nums[i];
    		while(l<r){
    			if(nums[l]+nums[r]==target){
    				List<Integer> res = new ArrayList<Integer>();
    				res.add(-target);
    				res.add(nums[l]);
    				res.add(nums[r]);
    				resList.add(res);
    				
    				do{l++;}
    				while(l<r && nums[l]==nums[l-1]);
    				do{r--;}
    				while(l<r && nums[r]==nums[r+1]);  				
    			}
    			else if(nums[l]+nums[r]>target){
    				r--;
    			}
    			else
    				l++;
    		}
    		
    	}
    	
    	return resList;
    }
    
    //16
    public int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);
    	int curRes=0; 
    	boolean isStart = false;
    	
    	for(int i=0; i<nums.length-2; i++){
    		int l=i+1, r= nums.length-1;
    		while(l<r){
    			int curSum = nums[i]+nums[l]+nums[r];
    			if(!isStart || Math.abs(curSum-target) < Math.abs(curRes-target)){
    				isStart = true;
    				curRes = curSum;
    			}
    			else if(nums[i]+nums[l]+nums[r]>target)
    				r--;
    			else
    				l++;
    		}
    	}
    	return curRes;
    }
}
