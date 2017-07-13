import java.util.Stack;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] nums = new int[]{3,5,3};
        int[] nums2 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int res = answer.maxArea(nums);
        int res2 = answer.trap_lfTraversal(nums2);
        
        System.out.println(res2);    
	}
	
	//11
	//two pointer
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
    
    
    //42
    //Two pointer
    //https://leetcode.com/articles/trapping-rain-water/#approach-1-brute-force-accepted
    
    //42
    //Stack
    public int trap(int[] height) {
    	if(height.length==0)
    		return 0;
    	
    	//store all index of hight which cannot find a higher pair till now
        Stack<Integer> st= new Stack<Integer>();
        
        int res=0;
        for(int i=0; i<height.length; i++){        	
        	//if there is a higher bar than pending bar in the stack, means all pending bar in stack with lower height is done
        	//we can get ammount of trapped water now
    		int bottom=0;	
    		if(!st.isEmpty() && height[st.peek()]<height[i]){
    			bottom = height[st.pop()];
    			
            	while(!st.isEmpty()){
            		int lIndex = st.peek();
            		int lH=height[lIndex];
            		int curH= Math.min(height[i], lH);
            		res+= (i-lIndex-1) * (curH - bottom);
            		bottom=curH;
            		
            		if(height[st.peek()]>height[i])
            			break;	
            		else{
            			st.pop();
            		}
            	}
    		}     	
        	st.push(i);     	
        }
        
        return res;
    }
    
    //42  
    //DP
    //left and right Traversal
    public int trap_lfTraversal(int[] height) {
    	//leftMax[i], from Left to right, max height index till i;
    	int[] leftMax = new int[height.length];
    	//rightMax[i], from right to left, max height index till i;
    	int[] rightMax = new int[height.length];
    	
    	for(int i=0; i<height.length; i++){
    		leftMax[i]=Math.max(i==0? 0: leftMax[i-1], height[i]);
    	}
    	
    	for(int i=height.length-1; i>=0; i--){
    		rightMax[i]=Math.max(i==height.length-1? 0: rightMax[i+1], height[i]);
    	}
    	
    	int res=0;
    	for(int i=1; i<height.length-1; i++){
    		int temp =Math.min(leftMax[i-1], rightMax[i+1])-height[i];
    		res+=temp>0? temp:0;
    	}
    	
    	return res;
    }
}
