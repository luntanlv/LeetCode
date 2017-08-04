import java.util.Stack;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{2,1,5,6,2,3};
        int res = answer.largestRectangleArea(input);
        
        System.out.println(res);         
	}
	
	//see solution, 3 different solution: stack, dp(same idea as stack), divide&Concur
	//Stack
    public int largestRectangleArea_st(int[] heights) {
        if(heights.length==0)
        	return 0;
        
        int res=0;	
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0; i<heights.length; i++){
        	int curH = heights[i];
        	if(st.isEmpty() || curH>=heights[st.peek()]){
        		st.push(i);
        	}
        	else{
        		int preIndex =0;
            	while(!st.isEmpty() && curH<heights[st.peek()]){
            		int heightIndex = st.pop();
            		preIndex = st.isEmpty()? 0: st.peek()+1;
            		int tempRes = heights[heightIndex]*(i-preIndex);
            		res=Math.max(res, tempRes);
            	}
            	
            	st.push(i);
        	}
        }
        
        int lastIndex=heights.length;
    	while(!st.isEmpty()){
    		int heightIndex = st.pop();
    		int preIndex = st.isEmpty()? 0: st.peek()+1;
    		int tempRes = heights[heightIndex]*(lastIndex-preIndex);
    		res=Math.max(res, tempRes);
    	}
    	
    	return res;
    }
    
    //dp, left and right scan
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0)
        	return 0;
    	
        int[] leftLowerIndex = new int[heights.length];
        int[] rightLowerIndex = new int[heights.length];
        
        leftLowerIndex[0]=0;
        for(int i=1; i<heights.length; i++){
        	if(heights[i]>heights[i-1]){
        		leftLowerIndex[i] = i;
        	}
        	else{
        		int preIndex=i-1;
        		while(preIndex>=0 && heights[i]<=heights[preIndex]){
        			leftLowerIndex[i]=leftLowerIndex[preIndex];
        			preIndex--;
        		}
        	}        	
        }
        
        rightLowerIndex[heights.length-1]=heights.length-1;
        for(int i=heights.length-2; i>=0; i--){
        	if(heights[i]>heights[i+1]){
        		rightLowerIndex[i] = i;
        	}
        	else{
        		int postIndex=i+1;
        		while(postIndex<heights.length && heights[i]<=heights[postIndex]){
        			rightLowerIndex[i]=rightLowerIndex[postIndex];
        			postIndex++;
        		}
        	}        	
        }
        
        int res=0;
        for(int i=0; i<heights.length; i++){
        	int tempRes = (rightLowerIndex[i]-leftLowerIndex[i]+1)*heights[i];
        	res = Math.max(res, tempRes);
        }
        return res;
    }
}
