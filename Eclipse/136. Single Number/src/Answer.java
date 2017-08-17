
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int[] input = new int[]{1,2,2,0,1};
        int res = answer.singleNumber(input);
        System.out.println(res);       
	}
	
	//136 :  every element appears two times except for one
	//I saw the solution
	// Logic: XOR will return 1 only on two different bits. So if two numbers are the same, XOR will return 0. Finally only one number left.
	//   A ^ A = 0 and A ^ B ^ A = B.
    public int singleNumber_2times(int[] nums) {
    	int n = nums.length;
        int result=nums[0];
        for(int i=1;i<n;i++)
        {
            result= result^nums[i];  /* Get the xor of all elements */
        }
        return result;
    }
    
    //137 :  every element appears three times except for one
    public int singleNumber_3times(int[] nums) {
        
    }
}
