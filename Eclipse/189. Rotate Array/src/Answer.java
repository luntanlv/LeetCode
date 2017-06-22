
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{1,2,3,4,5};
        answer.rotate(input,1);
        for(int val : input)
        	System.out.print(val + ", ");
	}
	
    //3 reverse
	//pay attention to index
	//and do k = k % n;
    public void rotate(int[] nums, int k) {
    	int n = nums.length;
    	k = k % n;
    	
    	reverse(nums, 0, n-1);
    	reverse(nums, 0, k-1);
    	reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int start, int end){
    	while(start<end){
    		int temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
    		start++;
    		end--;
    	}
    }	
	
	//Using Cyclic Replacements
    public void rotate_cyclic(int[] nums, int k) {
    	int n = nums.length;
    	k = k % n;
    	int startIndex =0;
    	
        for(int i=0; i<n; startIndex++){
        	int nextIndex = startIndex;
        	int curVal=nums[startIndex];
        	
        	do{
        		nextIndex = (nextIndex+k)%n;
        		
        		int nextVal = nums[nextIndex];
        		nums[nextIndex] = curVal;
        		curVal=nextVal;
        		
        		i++;
        	}
        	while(nextIndex != startIndex);    	
        }
    }
    
}
