
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{2,1,5,6,2,3};
        int res = answer.largestRectangleArea(input);
        
        System.out.println(res);         
	}
	
	//see solution, 3 different solution: stack, dp(same idea as stack), divide&Concur
	
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0)
        	return 0;
    	
    }
}
