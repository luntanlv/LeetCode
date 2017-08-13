
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
	
	//Similar to moris traversal, 94
    public void flatten(TreeNode root) {
    	TreeNode cur = root;
    	
    	while(cur!= null){
            if(cur.left !=null){
            	TreeNode pre = cur.left;
            	while(pre.right !=  null)
            		pre = pre.right;
            	pre.right = cur.right;
            	
            	cur.right = cur.left;
            	cur.left = null;
            }
            cur = cur.right;
    	}
    }
    
    //Post order traversal
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        
        flatten(left);
        flatten(right);
        
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }
}
