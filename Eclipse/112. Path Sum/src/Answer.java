
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
        
        boolean res = answer.hasPathSum(root,3);
        System.out.println(res);       
	}
	
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null)
    		return false; 
    	
    	if(root.left == null && root.right == null)
    		return sum - root.val == 0;
       
        boolean res_l = hasPathSum(root.left, sum-root.val);
        boolean res_r = hasPathSum(root.right, sum-root.val);
        
        return res_l || res_r;
    }
}
