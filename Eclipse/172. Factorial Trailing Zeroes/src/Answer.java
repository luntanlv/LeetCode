
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();  
        System.out.println();
	}
	
	
	// I saw the solution
	//https://discuss.leetcode.com/topic/6513/simple-c-c-solution-with-detailed-explaination
    public int trailingZeroes(int n) {
        int result = 0;
        for(long i=5; n/i>0; i*=5){
            result += (n/i);
        }
        return result;
    }
}
