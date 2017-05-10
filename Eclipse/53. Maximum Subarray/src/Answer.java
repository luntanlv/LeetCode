
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        
        int res = answer.maxSubArray(input);
        System.out.println(res);
	}
	
	//Dp
    public int maxSubArray(int[] nums) {
    	int[] maxEndByEachIndex = new int[nums.length];
    	maxEndByEachIndex[0] = nums[0];
    	int max = nums[0];
    	
    	for(int i =1; i<nums.length; i++){
    		maxEndByEachIndex[i]= nums[i] > maxEndByEachIndex[i-1]+nums[i] ? nums[i] : maxEndByEachIndex[i-1]+nums[i];
    		if(maxEndByEachIndex[i]> max)
    			max = maxEndByEachIndex[i];
    	}
    	return max;
    }	
    
    public int maxSubArray3(int[] nums) {
    	int maxEndByPreviousIndex = nums[0];
    	int max = nums[0];
    	
    	for(int i =1; i<nums.length; i++){
    	    int tempSum = maxEndByPreviousIndex+nums[i];
    		int tempRes = nums[i] > tempSum ? nums[i] : tempSum;
    		maxEndByPreviousIndex = tempRes;
    		if(tempRes > max)
    			max =tempRes;
    	}
    	return max;
    }    
	
    public int maxSubArray2(int[] nums) {

    	int[] res = divCon(nums, 0, nums.length-1);
    	
    	for(int i=res[1]; i<=res[2]; i++){
    		System.out.print(nums[i] + ", ");
    	}
    	System.out.println("");
    	return res[0];
    }	
    
    private int[] divCon(int[] nums, int start, int end){
    	if(start==end){
    		int[] result = new int[] {nums[start], start, end};
    		return result;
    	}

		int mid = (start+end)/2;
		
		int[] res1 = divCon(nums, start, mid);
		
		int[] res2 = divCon(nums, mid+1, end);
		
		int midRes1 =Integer.MIN_VALUE, midRes2 =Integer.MIN_VALUE, temp=0, midStart=mid, midEnd=mid;
		for(int i=mid; i>=start; i--){
			temp +=nums[i];
			if(temp>midRes1){
				midRes1= temp;
				midStart = i;
			}				
		}
		temp=0;
		for(int i=mid+1; i<=end; i++){
			temp +=nums[i];
			if(temp>midRes2){
				midRes2= temp;
				midEnd = i;
			}				
		}
		
		int midRes= midRes1 + midRes2;
		int[] res= new int[3];
		if(res1[0]>midRes){
			res = res1;
		}
		else{
			res[0] = midRes;
			res[1] = midStart;
			res[2] = midEnd;
		}
		
		if(res2[0]>res[0]){
			res = res2;
		}
		
		return res;
    }
}
