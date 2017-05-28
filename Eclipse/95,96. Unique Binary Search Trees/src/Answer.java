import java.util.ArrayList;
import java.util.List;

public class Answer {

	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        //List<TreeNode> res = answer.generateTrees(0);
        int res = answer.numTrees(4);
        System.out.println(res);       
	}
	
	//Use dp to save time
	//https://discuss.leetcode.com/topic/2940/java-solution-with-dp
	
	//just recursion
    public List<TreeNode> generateTrees(int n) {
    	if(n==0)
    		return new ArrayList<TreeNode>();
    	
    	List<TreeNode> res = helper(1,n);
    	return res;
    }
  
    private List<TreeNode> helper(int start, int end){
    	List<TreeNode> res = new ArrayList<TreeNode>();
    	
    	if(start>end){
    		res.add(null);
    		return res;
    	}
        	  		
    	for(int i=start; i<=end; i++){
    		
    		List<TreeNode> leftChildHeads =  helper(start, i-1);
    		List<TreeNode> rightChildHeads =  helper(i+1, end);
    		
    		for(TreeNode leftHead : leftChildHeads){
    			for(TreeNode rightHead : rightChildHeads){
    				TreeNode newRoot =  new TreeNode(i);
    				newRoot.left=leftHead;
    				newRoot.right=rightHead;
    				res.add(newRoot);
    			}
    		}
    		
    	}
    	
    	return res;

    }
    
    //96
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++){
        	for(int j=0; j<i; j++){
        		dp[i]+=dp[j] * dp[i-j-1];
        	}
        }
    	
        return dp[n];
    }

    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
       
}
