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
	//just recursion here
    public List<TreeNode> generateTrees_re(int n) {
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
    
    //dp
    public List<TreeNode> generateTrees(int n) {
    	//dp[i]:the list of root of BST for a sequence of length i.
    	List<TreeNode>[] dp = new ArrayList[n + 1];
    	
    	dp[0] = new ArrayList<TreeNode>();
    	if(n==0)
    		return dp[0];  	
    	dp[0].add(null);

    	for(int i=1; i<=n; i++){
    		dp[i] = new ArrayList<TreeNode>();
    		//for each length i, pick j+1 as root
    		for(int j=0; j<i; j++){
    			//left subtree j nodes, right subtree i-j-1 nodes
    			for(TreeNode nodeL : dp[j]){
    				for(TreeNode nodeR: dp[i-j-1]){
    					TreeNode newRoot = new TreeNode(j+1);
    					newRoot.left = clone(nodeL, 0);
    					newRoot.right = clone(nodeR, j+1);
    					dp[i].add(newRoot);
    				}
    			}    			
    		}
    		
    	}
    	
    	return dp[n];
    	
    }
    
    //clone the tree structure, with val=baseval + offset
    private TreeNode clone(TreeNode root, int offset){
    	if(root == null)
    		return null;
    	
    	TreeNode newRoot = new TreeNode(root.val + offset);
    	newRoot.left = clone(root.left, offset);
    	newRoot.right = clone(root.right, offset);
    	
    	return newRoot;
    }
    
    
    
    
    //96
    //https://leetcode.com/problems/unique-binary-search-trees/discuss/
	/*
	 * To construct an unique BST out of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root, 
	 * which is to say, we need to construct an unique BST out of its left subsequence [1, 2] 
	 * and another BST out of the right subsequence [4, 5, 6, 7], 
	 * and then combine them together. 
	 * 
	 * The tricky part is that we could consider the number of unique BST out of sequence [1,2] as dp(2), 
	 * and the number of of unique BST out of sequence [4, 5, 6, 7] as dp(4). Therefore, F(3,7) = dp(2) * dp(4).
	 */
    public int numTrees(int n) {
    	//dp[i]:the number of unique BST for a sequence of length i.
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i=1; i<=n; i++){
        	//for each length i, pick j+1 as root
        	for(int j=0; j<i; j++){
        		//left subtree j nodes, right subtree i-j-1 nodes
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
