import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] input = new int[]{0, 1, 0, 3, 12};
        answer.moveZeroes(input);
        System.out.println(input);       
	}
	
    public void moveZeroes(int[] nums) {
        int nonZcount =0;
        for(int i=0; i<nums.length; i++){
        	if(nums[i]!=0){
        		nums[nonZcount] = nums[i];
        		nonZcount++;
        	}
        }
        
        for(int i = nonZcount; i<nums.length; i++){
        	nums[i]=0;
        }
    }
}
