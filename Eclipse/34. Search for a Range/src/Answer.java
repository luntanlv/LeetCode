
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{5, 7, 7, 8, 8, 10};
        int[] res = answer.searchRange_better(input,8);
        //boolean res = answer.search81(input,8);
        for(int r: res)
        	System.out.print(r+", ");     
	}
	
	
	//One binary search and then liner search
    public int[] searchRange(int[] nums, int target) {
        int start=0, end = nums.length-1;
        while(start<=end){
        	int mid = start + (end-start)/2;
        	
        	if(nums[mid]==target){
        		int l=mid, r=mid;
        		while(l>=0 && nums[l]==target)
        			l--;
        		while(r<nums.length && nums[r]==target)
        			r++;
        		return new int[]{l+1, r-1};
        	}
        	
        	if(nums[mid]>target){
        		end = mid-1;
        	}
        	else{
        		start = mid+1;
        	}
        	
        }
        return new int[]{-1,-1};
    }
    
    //We can do better using two bianraye search
    public int[] searchRange_better(int[] nums, int target) {
        int start=0, end = nums.length-1;
        int l=0, r=0;
        
        //find the left point
        while(start<end){
        	int mid = start + (end-start)/2;
        	
        	if(nums[mid]>= target){
        		end = mid;
        	}
        	else{
        		start = mid+1;
        	}
        }
        l= start<=nums.length-1 && nums[start]==target? start: -1;
        
        if(l!=-1){
            //find right point
            //don't need to search again, only need to search start~nums.length-1
            end = nums.length-1;
            while(start<end-1){
            	int mid = start + (end-start)/2;
            	
            	if(nums[mid]>target){
            		end=mid-1;
            	}
            	else{
            		start = mid;
            	}
            }
            r=nums[end]==target? end: start;
            
           
        }
        else
        	r=-1;
        
        return new int[]{l,r};
    }
}
