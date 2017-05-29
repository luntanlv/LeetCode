
public class Answer {
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
    
    //1->2->3 shortest path is 3, instead of 1; the path has to go to a leaf, null is not a leaf
    public int minDepth(TreeNode root) {
        if(root ==  null)
            return 0;
    	
        if(root.left == null && root.right == null)
        	return 1;
        
        int d_l = Integer.MAX_VALUE, d_r = Integer.MAX_VALUE;
        if(root.left != null)
        	d_l = minDepth(root.left);
        
        if(root.right != null)
        	d_r = minDepth(root.right);
         
         return Math.min(d_l, d_r)+1;
         
    }
    
    //more shorter code
    public int minDepth_shorter(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
       
    }
    
    
    //We can do leverl order traversal too
    
}
