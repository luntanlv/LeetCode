
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int res = answer.hammingWeight(-2147483647);
        System.out.println(res);       
	}
	
    // you need to treat n as an unsigned value
	//10000000000000000000000000000001 will be 2147483649, instead of -2147483647
    public int hammingWeight(int n) {
    	int count=0;
    	if(n<0){
    		n= n^(1<<31);
    		count++;
    	}
        while(n>0){
        	int lastDigit = n&1;
        	if(lastDigit==1)
        		count++;
        	n=n>>1;
        }
        return count;
    }
    
    //Concise
    //We need to use bit shifting unsigned operation >>> (while >> depends on sign extension)
    public static int hammingWeight_better(int n) {
    	int ones = 0;
        	while(n!=0) {
        		ones = ones + (n & 1);
        		n = n>>>1;
        	}
        	return ones;
    }
}
