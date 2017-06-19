
public class Answer {

	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int[] input = new int[]{1,2,3,4};
        int[] res = answer.productExceptSelf(input);
        System.out.println(res);       
	}
	
	//O(1) space
	//I got this from O(n) solution
    public int[] productExceptSelf(int[] nums) {
    	int[] res = new int[nums.length];
    	res[0]=1;
    	for(int i=1; i<nums.length; i++){
    		res[i]=res[i-1]*nums[i-1];
    	}
    	
    	int cur =1;
        for(int i=nums.length-2; i>=0; i--){
        	cur*=nums[i+1];
        	res[i]=res[i]*cur;
        }
        
        return res;
    }
	
	//O(n) space
	//I saw the solution
	//	 The idea is to store product of numbers at the left side to A and product of numbers at right side to B.
	//	 i.e. A[i] = nums[0] * nums[1] ... * nums[i-1]; B[i] = nums[N] * nums[N-1] ... * nums[i+1];
	//	 As you can plainly see, Result[i] = A[i] * B[i]
    public int[] productExceptSelf_nspace(int[] nums) {
        int[] A = new int[nums.length];
        A[0]=1;
        int[] B = new int[nums.length];
        B[nums.length-1]=1;
        
        for(int i=1; i<nums.length; i++){
        	A[i]= A[i-1]*nums[i-1];
        }
        
        for(int i=nums.length-2; i>=0; i--){
        	B[i]= B[i+1]*nums[i+1];
        }
        
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
        	res[i] = A[i]* B[i];
        }
        
        return res;
    }
}
