
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{1,1,1,2,2,2,2,3,3};
        //char[][] input = new char[][]{{'A'}};
        int res = answer.removeDuplicates(input);
        
        System.out.println(res);
        for(int num: input){
        	 System.out.print(num+", ");
        }
            
	}
	//leverage sorted array
	public int removeDuplicates(int[] nums) {
	    int i = 0;
	    for (int n : nums)
	        if (i < 2 || n > nums[i-2])
	            nums[i++] = n;
	    return i;
	}	
	
	//can do without sorted array
    public int removeDuplicates2(int[] nums) {
        if(nums.length==0)
        	return 0;
    	
    	int cur =nums[0];
    	int dupCount=0;
    	int lastPos=1;
    	
    	for(int i=1; i<nums.length; i++){
    		if(nums[i]==cur){
    			dupCount++;
    			if(dupCount>=2)
    				continue;
    			else{
    				nums[lastPos++] = nums[i];
    			}
    		}
    		else{
    			dupCount=0;
    			cur=nums[i];
    			nums[lastPos++] = nums[i];
    		}
    	}
    	
    	return lastPos;
    }
}
