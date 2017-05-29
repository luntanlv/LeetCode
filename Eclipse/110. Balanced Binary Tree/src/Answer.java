
public class Answer {
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
    
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        TreeNode root = answer.new TreeNode(1);
        
        boolean res = answer.isBalanced(root);
        System.out.println(res);       
	}
	
	
	//top down O(n^2)
    public boolean isBalanced(TreeNode root) {
    	if(root == null)
    		return true;
    	
    	int left = height(root.left);
    	int right = height(root.right);
    	
    	if(Math.abs(left-right)>1)
    		return false;
    	else
    		return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root){
    	if(root == null)
    		return 0;
    	
    	int h_left = height(root.left);
    	int h_right = height(root.right);
    	
    	return Math.max(h_left, h_right)+1;
    		
    }
    
    //bottum up
    //dfs postOrder, O(n)
    public boolean isBalanced_DFS(TreeNode root) {
    	return dfs(root)==-1? false: true;
    }
    
    private int dfs(TreeNode root){
    	if(root == null)
    		return 0;
    	
    	int h_left = dfs(root.left);
    	int h_right = dfs(root.right);
    	
    	if(h_left ==-1 || h_right==-1)
    		return -1;
    	
    	if(Math.abs(h_left-h_right)>1)
    		return -1;
    	else
    		return Math.max(h_left, h_right)+1;
    		
    }
}
