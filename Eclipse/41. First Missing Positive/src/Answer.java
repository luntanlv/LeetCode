
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{1,1,1};
        int res = answer.firstMissingPositive(input);
        //boolean res = answer.search81(input,8);
        System.out.println(res);      
	}
	
	// I saw the solution
	//similar 
	//https://leetcode.com/problems/find-the-duplicate-number/#/description
    public int firstMissingPositive(int[] nums) {

        for(int i=0; i<nums.length; i++){
        	// nums[i]!=nums[nums[i]-1] key point to avoid infinity loop, if on element already at right position, then skip, so loop won't happen
        	while(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]){
        		int temp = nums[nums[i]-1];
        		nums[nums[i]-1] = nums[i];
        		nums[i]=temp;
        	}
        }
        
        for(int i=0; i<nums.length; i++){
        	if(nums[i]!=i+1){
        		return i+1;
        	}
        		
        }
        return nums.length+1;
    }

}
