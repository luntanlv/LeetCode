
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] input = {3,2,1,0,4};
        
        boolean res = answer.canJump(input);
        System.out.println(res);
	}
	
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(i>max) {return false;}
            max = Math.max(nums[i]+i,max);
        }
        return true;
    }    
    
    public boolean canJump2(int[] nums) {
        boolean[] canBeGet = new boolean[nums.length];
        canBeGet[0]=true;
        for(int i=0; i<nums.length-1; i++){
        	if(!canBeGet[i])
        		continue;       	
        	for(int j=1; j<=nums[i];j++){
        		canBeGet[i+j]=true;
        	}
        }
        return canBeGet[canBeGet.length-1];
    }
}
