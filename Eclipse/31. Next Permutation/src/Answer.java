
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] input = new int[]{2, 4, 3, 1};
        int[] input2 = new int[]{5, 1, 1};
        answer.nextPermutation(input2);
        for(int v: input2)
        	System.out.print(v+", ");       
	}
	
    public void nextPermutation(int[] nums) {
    	int len = nums.length;
    	int index=len-1;
    	while(index>=0 && (index==len-1 || nums[index]>=nums[index+1])){
    		index--;
    	}
    	
    	if(index >=0){
    		int curIndex = index+1;
    		while(curIndex<len && nums[index]<nums[curIndex]){
    			curIndex++;
    		}
			int temp = nums[curIndex-1];
			nums[curIndex-1] = nums[index];
			nums[index] = temp;
    		
    		reverse(nums, index+1, len-1);
    	}
    	else
    		reverse(nums, 0, len-1);
    }
    
    private void reverse(int[] nums, int l, int r){
    	while(l<r && l<nums.length && r>=0){
    		int temp= nums[l];
    		nums[l]=nums[r];
    		nums[r]=temp;
    		l++;
    		r--;
    	}
    }
}
