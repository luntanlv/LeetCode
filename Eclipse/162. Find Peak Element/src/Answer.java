
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{1,2};
        int res = answer.findPeakElement(input);
        System.out.print(res);
	}
	
	//O(logn)
	//I saw the solution
	//https://discuss.leetcode.com/topic/5848/o-logn-solution-javacode
	//https://discuss.leetcode.com/topic/5724/find-the-maximum-by-binary-search-recursion-and-iteration
	//Since You may imagine that num[-1] = num[n] = -¡Þ. there is always solution
	//So use binary search
    public int findPeakElement(int[] nums) {
    	int l =0, r = nums.length -1;
    	while(l<r){
    		int mid = l + (r-l)/2;
        	long pre = mid-1<0? Long.MIN_VALUE: nums[mid-1];
        	long after = mid+1>nums.length-1? Long.MIN_VALUE: nums[mid+1];
        	
        	if(nums[mid]>pre && nums[mid]>after){
        		return mid;
        	}
        	else if(nums[mid]>pre && nums[mid]<after){
        		l = mid+1;
        	}
        	else{
        		r = mid-1;
        	}
    	}
    	return nums[l]<nums[r]? r: l;
    }
	
	//O(n)
    public int findPeakElement_On(int[] nums) {
        for(int i=0; i<nums.length;i++){
        	long pre = i-1<0? Long.MIN_VALUE: nums[i-1];
        	long after = i+1>nums.length-1? Long.MIN_VALUE: nums[i+1];
        	
        	if(nums[i]>pre && nums[i]>after)
        		return i;
        }
        return -1;
    }
}
