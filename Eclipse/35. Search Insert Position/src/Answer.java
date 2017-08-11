
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{6,7,1,2,4,5};
        int res = answer.searchInsert(input,9);
        //boolean res = answer.search81(input,8);
        System.out.println(res);    
	}
	
    //Second round
    public int searchInsert2(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<high-1){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid;
            else low = mid+1;
        }
        return A[low]>=target? low:  A[high]>=target? high: high+1;
    }
    
    //First round
    public int searchInsert(int[] nums, int target) {
        int start=0, end=nums.length-1;
        while(start<end){
        	int mid = start + (end-start)/2;
        	
        	if(nums[mid]==target)
        		return mid;
        	
        	if(nums[mid]>target)
        		end = mid-1;
        	else
        		start= mid+1;
        }
        return end<0? 0: nums[end]<target?end+1:end;
    }
}
