
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
    
    //260
    /*
     * In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find. 
     * Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result. 
     * Find out an arbitrary set bit (for example, the rightmost set bit).
     * 
     * I think using the rightmost 1-bit is just for ease of coding (diff &= -diff will leave the rightmost 1-bit). 
     * In fact, you can use any 1-bit. This 1-bit implies that the two single numbers are different at this bit. 
     * Then we use this bit to split all the remaining numbers into two groups. 
     * Suppose the two single numbers are a and b and they differ in the third bit (a is 1 at this bit while b is 0). 
     * After splitting, numbers with 1 in the third bit will fall in the group of a while the remaining ones fall in the group of b. 
     * Till now, we will be able to get a and b via a simple within-group xor.
     * 
     */
    
    public int[] singleNumber(int[] nums) {
    	int n = nums.length;
        int xor2=nums[0];
        for(int i=1;i<n;i++)
        {
        	xor2= xor2^nums[i];  /* Get the xor of all elements */
        }
        
        //get right most bit with value of 1 (set bit)
        int diff=1;
        while((diff & xor2) != diff)
        	diff<<=1;
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
        
    }
}
