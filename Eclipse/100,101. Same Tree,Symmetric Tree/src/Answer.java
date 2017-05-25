import Answer.TreeNode;

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
        TreeNode root = answer.new TreeNode(2);
        TreeNode left = answer.new TreeNode(1);
        TreeNode right = answer.new TreeNode(3);
        root.left=left;
        root.right= right;
        answer.recoverTree(root);
        System.out.println(root);       
	}
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p == null && q== null)
    		return true;
    	
    	if((p == null && q != null) || (p != null && q == null) || (p.val != q.val))
    		return false;
    	
    	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    public boolean isSymmetric(TreeNode root) {
    	if(root == null)
    		return true;
    	return isSymmetricHelper(root.left, root.right);
    }
    
    public boolean isSymmetricHelper(TreeNode p, TreeNode q) {
    	if(p == null && q== null)
    		return true;
    	
    	if((p == null && q != null) || (p != null && q == null) || (p.val != q.val))
    		return false;
    	
    	return isSymmetricHelper(p.left, q.right) && isSymmetricHelper(p.right, q.left);        
    }
}
