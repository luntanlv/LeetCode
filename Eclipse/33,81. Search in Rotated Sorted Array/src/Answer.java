import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{1,2,3};
        int res = answer.search33(input,3);
        System.out.println(res);

            
	}	
	
    public int search33(int[] nums, int target) {
    	int rotationTimes = getRotation33(0, nums.length-1, nums);
    	return rotationTimes;
    }
    
    //find the index of end before rotation 
    private int getRotation33(int start, int end, int[]nums){  	

    	if(start == end)
    		return start;
    	
    	int mid = (start + end)/2;
    	//33: no dup
    	int res;
    	if(nums[start]>=nums[mid])
    		res = getRotation33(start, mid, nums);
    	else 
    		res = getRotation33(mid, end, nums);
    		
    	
    	return res;
    }
}
