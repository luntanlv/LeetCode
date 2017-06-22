
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] input = new int[]{3,4,0,1,2};
        int res =answer.findMin(input);
        System.out.println(res);       
	}
	
	//Binary searh:
	//loop invariant: The rotation break point (Max num) always in [left, right]
    public int findMin(int[] nums) {
        int left=0, right=nums.length-1;
        
        while(left<right-1){
        	int mid = left + (right-left)/2;
        	if(nums[left]<=nums[mid]){
        		left = mid;
        	}
        	else if(nums[left]>nums[mid]){
        		right = mid-1;
        	}
        }
        //when stop left an right val can be 3,4 or 4,0, so find the max
        int maxIndex = nums[left]>nums[right]? left: right;
        int minIndex = (maxIndex+1)%nums.length;
        return nums[minIndex];   	
    }
    
	//loop invariant: There is rotaion and The rotation break point (Min num) always in [left, right]
    public int findMin(int[] nums) {
        int left=0, right=nums.length-1;
        
        while(left<right){
        	//Looking at subarray with index [start,end]. We can find out that if the first member is less than the last member, 
        	//there's no rotation in the array. So we could directly return the first element in this subarray.
        	if(nums[left]<nums[right])
        		return nums[left];
        	
        	int mid = left + (right-left)/2;
        	if(nums[left]<=nums[mid]){
        		left = mid+1;
        	}
        	else if(nums[left]>nums[mid]){
        		right = mid;
        	}
        }
        //if code run to here, means it is 4,0 case in previous step: nums[left]=nums[mid], left = mid+1; so left is the max
        return nums[left];   	
    }
}
