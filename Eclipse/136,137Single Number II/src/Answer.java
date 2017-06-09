
public class Answer {

	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int[] input = new int[]{-4,-4,-4,-4, 3,3,3,3, -7,-7,-7};
        int res = answer.singleNumber(input);
        System.out.println(res);       
	}
	
    public int singleNumber(int[] nums) {
    	return singleNumber_straightforwardversion(nums, 4);
    }
	
	//for General k times
    public int singleNumber_straightforwardversion(int[] nums, int k) {
    	//for 32 bits integers, I create 1 counter for each bit, each counter is a integer
    	int[] counters = new int[32];
    	
    	for(int i=0; i<32; i++){
        	for(int num : nums){
        		//count 1 for ith bit over all input
        		//cannot use >0, since when i=31, 1000 0000 0000 (total 31 ¸ö 0)... is <0
        		if( (num & (1<<i)) != 0)
        		counters[i]++;
        	}    		
    	}
    	
    	int res =0;
        for(int i=0; i<32; i++)
        {
            if(counters[i]%k>0)
                res = res | 1<<i;
        }
        
        return res;
    }
	
	//All item k timms, excpet one p time, p<k
	//https://discuss.leetcode.com/topic/11877/detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers/2
	// input is 32 bits intege, I only show lowest four here.
	//
	// input       counter(m ¸ö32 bits integers) m=log(k)
	// 1011        X1 (a)|000 0000 0000 0000 0000 0000 0000 0000 
	// 1011        X2 (b)|000 0000 0000 0000 0000 0000 0000 0000 
	// 1011
	// 0010        (b)(a) is the (count%k) of 1 for the highest bit in input,
	// 0010        if this bit of the single item number is 1, (b)(a) won't be 0, otherwise (b)(a) should be 0
	// 0010	
	// 0011
	// 0011
	// 0011	
	// 0100
	// 0100
    public int singleNumber_advanced(int[] nums) {
        int x1 = 0;   
        int x2 = 0; 
        int mask = 0;
  
        for (int i : nums) {
           x2 ^= x1 & i;
           x1 ^= i;
           mask = ~(x1 & x2);
           x2 &= mask;
           x1 &= mask;
        }

        return x1;  // p = 1, in binary form p = '01', then p1 = 1, so we should return x1; 
                    // if p = 2, in binary form p = '10', then p2 = 1, so we should return x2.
    }
}
