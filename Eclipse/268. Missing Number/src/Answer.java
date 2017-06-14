
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] input = new int[]{3,0,1};
        int res =answer.missingNumber(input);
        System.out.println(res);       
	}
	
	//sum solution+
	//https://discuss.leetcode.com/topic/22299/java-solution-o-1-space-and-o-n-in-time
	
	public class Solution {
	    public int missingNumber(int[] nums) {
	        int sum = 0;
	        for(int num: nums)
	            sum += num;
	            
	        return (nums.length * (nums.length + 1) )/ 2 - sum;
	    }
	}
	
	//XOR solution
	//https://discuss.leetcode.com/topic/24535/4-line-simple-java-bit-manipulate-solution-with-explaination
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int num: nums)
            sum += num;
            
        return (nums.length * (nums.length + 1) )/ 2 - sum;
    }
	
	//My solution
    public int missingNumber_swap(int[] nums) {
    	int n =nums.length;
    	
        for(int i=0; i<n; i++){

        	while(i!=nums[i] && nums[i]>=0){
        		if(nums[i] == n){
        			nums[i] = -1;
        		}
        		else{
            		int temp = nums[nums[i]];
            		nums[nums[i]]=nums[i];
            		nums[i]= temp;        			
        		}
        	}
        }
        
        for(int i=0; i<n; i++){
        	if(nums[i]==-1)
        		return i;
        }
        return n;
    }
}
