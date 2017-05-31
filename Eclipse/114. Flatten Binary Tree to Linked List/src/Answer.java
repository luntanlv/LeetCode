
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
}