
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] input = new int[]{2, 4, 3, 1};
        int[] input2 = new int[]{5, 1, 1};
        answer.nextPermutation(input2);
        for(int v: input2)
        	System.out.print(v+", ");       
	}
	
	//Range binary search
	//https://discuss.leetcode.com/topic/25580/two-solutions-with-explanation-o-nlog-n-and-o-n-time-o-1-space-without-changing-the-input-array
    public int findDuplicate_BS(int[] nums) {
        int n = nums.length-1;
        int l = 1, h = n;
        
        while(){
        	int m = (l+h)/2;
        }
    }
	
	//I saw the solution
	//https://leetcode.com/problems/linked-list-cycle-ii/#/description
    public int findDuplicate(int[] nums) {
    	int slow = nums[0];
    	int fast = nums[slow];
    	int meetIndex=0;
        while(true){
        	if(slow == fast){
        		meetIndex=slow;
        		break;
        	}
        	slow=nums[slow];
        	fast=nums[nums[fast]];
        }
        
        int startAgainIndex=0;
        while(startAgainIndex != meetIndex){
        	startAgainIndex = nums[startAgainIndex];
        	meetIndex = nums[meetIndex];
        }
        
        return startAgainIndex;
    }
	
	//Wrong: I cannot modify the array
    public int findDuplicate_modifiedArray(int[] nums) {
    	int res=0;
    	while(true){
    		int cur = nums[0];
    		if(cur==nums[cur]){
    			res = cur;
    			break;
    		}
    		nums[0]=nums[cur];
    		nums[cur]=cur;
    	}
    	return res;
    }
}
