
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{5,1,2,3,4};
        int res = answer.rob(input);
        System.out.print(res);
	}
	
	//198
	//I saw the solution
	//https://leetcode.com/articles/house-robber/#approach-1-dynamic-programming-accepted
	public int rob(int[] num) {
	    int prevMax = 0;
	    int currMax = 0;
	    for (int x : num) {
	        int temp = currMax;
	        currMax = Math.max(prevMax + x, currMax);
	        prevMax = temp;
	    }
	    return currMax;
	}
}
