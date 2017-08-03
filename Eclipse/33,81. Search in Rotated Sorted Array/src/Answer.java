import java.util.List;

/*
 * How to set stop condition and next move for binary search
 * 
 * http://blog.csdn.net/ebowtang/article/details/50770315
 */

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{6,7,1,2,4,5};
        int res = answer.search33_sol2(input,9);
        //boolean res = answer.search81(input,8);
        System.out.println(res);

            
	}	
	
	/*
	 *  33, no dup in nums
	 */
	//improve from sol2
	public int search_sol2_improve(int[] A, int target) {
	    int lo = 0;
	    int hi = A.length - 1;
	    while (lo < hi) {
	        int mid = (lo + hi) / 2;
	        if (A[mid] == target) return mid;
	        
	        if (A[lo] <= A[mid]) {
	            if (target >= A[lo] && target < A[mid]) {
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        } else {
	            if (target > A[mid] && target <= A[hi]) {
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	    }
	    return A[lo] == target ? lo : -1;
	}	
	
	
    public int search33_sol2(int[] nums, int target) {
    	if(nums.length==0)
    		return -1;
    	
    	int start =0, end = nums.length-1;
    	
    	while(start<end){
    		int mid = start + (end-start)/2;
    		
    		if(nums[mid]==target)
				return mid;

    		if(nums[start] > nums[mid]){
    			if(nums[mid]>target || nums[end]<target)
    				end = mid-1;
    			else if(nums[end]==target)
    				return end;
    			else
    				start = mid +1;
    				
    		}
    		else if(nums[start] < nums[mid]){
    			if(nums[start]>target || nums[mid]<target)
    				start = mid+1;
    			else if(nums[start]==target)
    				return start;
    			else
    				end = mid -1;
    		}
    		else
    			if(nums[mid] == target)
    				return mid;
    			else
    				start = mid+1;


    	}
    	
    	return nums[start]==target? start: -1;
    }
	
	
    public int search33(int[] nums, int target) {
    	if(nums.length==0)
    		return -1;
    	
    	int lastIndex = getUnshiftedLastIndex33(0, nums.length-1, nums);
    	int rotationTimes = (lastIndex+1)%nums.length;
    	int start =0, end = nums.length-1;
    	
    	while(start<=end){
    		int mid = start + (end-start)/2;
    		int realMid = (mid+rotationTimes)%(nums.length);

    		if(nums[realMid] > target)
    			end = mid-1;
    		else if(nums[realMid] < target)
    			start = mid+1;
    		else
    			return realMid;
    	}
    	
    	return -1;
    }
    
    //find the index of end before rotation 
    //without dp in nums
    //Return the index of unshifed's last item
    private int getUnshiftedLastIndex33(int start, int end, int[]nums){  	

    	if(start >= end-1)
    		return nums[start]>nums[end]? start:end;
    	
    	int mid = (start + end)/2;
    	//33: no dup
    	int res;
    	if(nums[start]>nums[mid])
    		res = getUnshiftedLastIndex33(start, mid, nums);
    	else if(nums[start]<nums[mid])
    		res = getUnshiftedLastIndex33(mid, end, nums);
    	//nums[start]==nums[mid] will not happen if there is no dup in nums, since when nums[start]==nums[mid] means start == end-1
    	else
    		return nums[start]>nums[end]? start:end;
    	
    	return res;
    }
    
    
	/*
	 *  81, have dup in nums
	 *  find the first match one,
	 *  return bool to indicate whether there is a match
	 */
    //Need to think about following case. I always miss that.
    //1,2,1,1,1,1 ->2
    public boolean search81_slo1(int[] nums, int target) {
        if(nums.length==0)
            return false;
        
        int start=0, end=nums.length-1;
        
        while(start<end-1){
            int mid = start + (end-start)/2;
            
            if(nums[mid]==target)
                return true;
            
            if(nums[start]<nums[mid]){
                if(target>=nums[start] && target<nums[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }            
            }
            else if(nums[start]>nums[mid]){
                if(target>nums[mid] && target<=nums[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }   
            }
            else{
                start++;
            }
        }
        
        return nums[start]==target || nums[end] ==target; 
    }
    
    public boolean search81_sol2(int[] nums, int target) {
    	if(nums.length==0)
    		return false;
    	int start =0, end = nums.length-1;
    	
    	while(start<=end){
    		int mid = start + (end-start)/2;
    		
    		if(nums[mid]==target)
    			return true;
    		
    		if(nums[start] > nums[mid] || nums[mid] < nums[end]){
    			if(nums[mid]<target && nums[end]>target)
    				start = mid +1;
    			else
    				end = mid - 1;
    				
    		}  		
    		else if(nums[start] < nums[mid] || nums[mid] > nums[end]){
    			if(nums[start]<target && nums[mid]>target)
    				end = mid - 1;
    			else
    				start = mid +1;				
    		}
    		//If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but start++ works too
    		else
    			start++;			
    	}
    	
    	return false;
    }    
    
    
    public boolean search81(int[] nums, int target) {
    	if(nums.length==0)
    		return false;
    	
    	int lastIndex = getUnshiftedLastIndex81(0, nums.length-1, nums);
    	int rotationTimes = (lastIndex+1)%nums.length;
    	int start =0, end = nums.length-1;
    	
    	while(start<end){
    		
    		int mid = start + (end-start)/2;
    		int realMid = (mid+rotationTimes)%(nums.length);
    		
    		if(nums[realMid] > target)
    			end = mid-1;
    		else if(nums[realMid] < target)
    			start = mid+1;
    		else
    			end = mid;
    		
    	}
    	
    	int realStart = (start+rotationTimes) % nums.length;
    	int res = nums[realStart] == target? realStart : -1;
    	
    	System.out.println(realStart);
    	return res==-1? false: true;
    }
    
    //find the index of end before rotation 
    //with dp in nums
    private int getUnshiftedLastIndex81(int start, int end, int[]nums){  	

    	if(start >= end-1)
    		return nums[start]>nums[end]? start:end;
    	
    	int mid = (start + end)/2;
    	//33: no dup
    	int res;
    	if(nums[start]>nums[mid])
    		res = getUnshiftedLastIndex81(start, mid, nums);
    	else if(nums[start]<nums[mid])
    		res = getUnshiftedLastIndex81(mid, end, nums);
    	//nums[start]==nums[mid], can not make any desssion, try start+1
    	//1,3,1,1; 7,7,1
    	else
    		res = getUnshiftedLastIndex81(start+1, end, nums);
    	
    	return res;
    }
}
