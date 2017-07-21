
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{6,7,1,2,4,5};
        int res = answer.searchInsert(input,9);
        //boolean res = answer.search81(input,8);
        System.out.println(res);    
	}
	
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
