
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] nums = new int[]{3,5,3};
        int res = answer.maxArea(nums);
        
        System.out.println(res);    
	}
	
	// I saw the solution\
	// From DP to Greedy O(n)
	// https://discuss.leetcode.com/topic/50763/from-dp-to-greedy-o-n-with-explanation-easy-way-to-see-this-problem
    public int maxArea(int[] height) {
        int l=0, r=height.length-1;
        int max=0;
        while(l<r){
        	int curH = Math.min(height[l], height[r]);
        	max=Math.max(max, curH*(r-l));
        	if(curH==height[l])
        		l++;
        	else
        		r--;
        }
        return max;
    }
}
