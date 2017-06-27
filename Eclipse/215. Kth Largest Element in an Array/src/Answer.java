
public class Answer {

	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{5,1,2,3,4};
        int res = answer.findKthLargest(input,1);
        System.out.print(res);
	}
	
    public int findKthLargest(int[] nums, int k) {
    	return quickSlect(nums, nums.length-k, 0, nums.length-1);
    }
    
    private int quickSlect(int[] nums, int k, int l, int r){
    	int p = partition(nums, l, r);
    	if(p==k)
    		return nums[k];
    	else if(p<k){
    		return quickSlect(nums, k, p+1, r);
    	}
    	else{
    		return quickSlect(nums, k, l, p-1);
    	}
    }
    
    private int partition(int[] nums, int l, int r){
    	int i=l-1;
    	for(int j=l; j<r; j++){
    		if(nums[j]<nums[r]){
    			i++;
    			int temp=nums[i];
    			nums[i] = nums[j];
    			nums[j] = temp;
    		}
    	}
    	i++;
		int temp=nums[i];
		nums[i] = nums[r];
		nums[r] = temp;
		
		return i;
    }
}
