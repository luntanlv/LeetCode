import java.util.Stack;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        TreeNode root = answer.new TreeNode(2);
        TreeNode left = answer.new TreeNode(1);
        TreeNode right = answer.new TreeNode(3);
        root.left=left;
        root.right= right;
        boolean res = answer.isValidBST(root);
        System.out.println(res);       
	}
	
	//doing inorder traversal
    public boolean isValidBST(TreeNode root) {
    	TreeNode pre = null;
        TreeNode cur = root;
        Stack<TreeNode> st = new Stack<TreeNode>();
       
        while(cur!= null || !st.isEmpty()){
        	if(cur != null){
        		st.push(cur);
            	cur=cur.left;
        	}
        	else{
        		cur=st.pop();
        		if(pre!=null && pre.val>=cur.val)
        			return false;
        		pre = cur;
        		cur = cur.right;
        	}

        }
        return true;
    }
    
    //solution two
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
