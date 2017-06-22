
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{1,2,3,4,5};
        answer.rotate(input,2);
        System.out.println(input);
	}
	
    public void rotate(int[] nums, int k) {
    	k = k % nums.length;
    	
        for(int i=0; i<k; i++){
        	int nextIndex = i+k;
        	int curVal=nums[i];
        	
        	while(nextIndex < nums.length){
        		int nextVal = nums[nextIndex];
        		nums[nextIndex] = curVal;
        		curVal=nextVal;
        		nextIndex += k;
        	}
        	nums[nextIndex%nums.length] = curVal;       	
        }
    }
}
