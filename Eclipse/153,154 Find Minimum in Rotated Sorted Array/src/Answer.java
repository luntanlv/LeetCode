
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] input = new int[]{3,3,1,3,3,3,3};
        int res =answer.findMin_154_better(input);
        System.out.println(res);       
	}
	
	//153
	//Binary searh:
	//loop invariant: The rotation break point (Max num) always in [left, right]
    public int findMin_maxfirst(int[] nums) {
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
    
    //153
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
    
    //154
    //find the right most max number first and +1 to get minimum number
    //not easy to write it right
    public int findMin_154(int[] nums) {
    	int left=0, right=nums.length-1;
    	
    	while(left<right-1){
    		int mid = left + (right-left)/2;
    		
    		if(nums[left]<nums[mid]){
    			left = mid;
    		}
    		else if(nums[left]>nums[mid]){
    			right = mid-1;
    		}
    		//nums[left]==nums[mid]
    		else{
    			//left might be the max
    			if(nums[left]>nums[left+1])
    				right--;
    			//left will not be the max
    			else
    				left++;
    		}
    	}
    	//find the right most max
    	int max =0;
    	if(nums[left]<nums[right])
    		max=right;
    	else if(nums[left]>nums[right])
    		max= left;
    	else{
    		if(left ==0 && right==nums.length-1)
    			max =left;
    		else
    			max=right;
    	}

    	int min = (max+1)%nums.length;
    	return nums[min];
    }
    
    //directly find the min
    //better
    public int findMin_154_better(int[] nums) {
    	int left=0, right=nums.length-1;
    	
    	while(left<right-1){
        	//Looking at subarray with index [start,end]. We can find out that if the first member is less than the last member, 
        	//there's no rotation in the array. So we could directly return the first element in this subarray.
        	if(nums[left]<nums[right])
        		return nums[left];
    		
    		int mid = left + (right-left)/2;
    		
    		if(nums[left]<nums[mid]){
    			left = mid+1;
    		}
    		else if(nums[left]>nums[mid]){
    			right = mid;
    		}
    		//nums[left]==nums[mid]
    		else{
    			left++;
    		}
    	}
    	
    	return Math.min(nums[left],nums[right]);
    }
}
