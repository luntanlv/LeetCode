import java.util.HashMap;

public class Answer {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}	

	//http://www.javaworld.com/article/2077424/learn-java/does-java-pass-by-reference-or-pass-by-value.html
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        TreeNode root = answer.new TreeNode(0);
        TreeNode node1 = answer.new TreeNode(1);
        TreeNode node2 = answer.new TreeNode(2);
        TreeNode node3 = answer.new TreeNode(3);
        
        root.left = node1;
        root.right = node2;
        node2.right = node3;
        
        TreeNode res = answer.lowestCommonAncestor(root, node1, node3);
        System.out.println(res.val);       
	}
	
	
    //better recursion
    public TreeNode lowestCommonAncestor_recursion_better(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
        	return root;
        TreeNode left = lowestCommonAncestor_recursion_better(root.left, p, q);
        TreeNode right = lowestCommonAncestor_recursion_better(root.right, p, q);
        if(left != null && right != null)   
        	return root;
        else
        	return left != null ? left : right;
    }	
	
	//Java manipulates objects 'by reference,' but it passes object references to methods 'by value.'
	//That is why I use dummy
	//dfs inoder travesal
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	TreeNode dummy = new TreeNode(0);
    	inorder(root, p, q, dummy);
    	return dummy.left;
    }
    
    private boolean[] inorder(TreeNode root, TreeNode p, TreeNode q, TreeNode ca){
    	if(root == null)
    		return new boolean[2];
    	
    	boolean[] resL = inorder(root.left, p, q, ca);
    	boolean[] resR = inorder(root.right, p, q, ca);
    	
    	boolean[] isNodeFound = new boolean[2];
    	
    	if(root == p)
    		isNodeFound[0] = true;
    	else if(root == q)
    		isNodeFound[1] = true;   
    	
    	isNodeFound[0] = isNodeFound[0]||resL[0]||resR[0];
    	isNodeFound[1] = isNodeFound[1]||resL[1]||resR[1];
    	
    	if(isNodeFound[0] && isNodeFound[1] && ca.left == null){
    		ca.left =root;
    	}    	
    		
    	return isNodeFound;
    }
	

    
	//recursion using dp memory
    public TreeNode lowestCommonAncestor_recursion(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, Boolean> dp_p = new HashMap<TreeNode, Boolean>();
        HashMap<TreeNode, Boolean> dp_q = new HashMap<TreeNode, Boolean>();
        
        TreeNode cur = root;
        while(true){
        	boolean resL = isAncestor(cur.left, p, dp_p) && isAncestor(cur.left, q, dp_q);
        	boolean resR = isAncestor(cur.right, p, dp_p) && isAncestor(cur.right, q, dp_q);
        	if(!resL && !resR)
        		break;
        	cur = resL? cur.left: cur.right;
        }
        
        return cur;
    }
    
    private boolean isAncestor(TreeNode root, TreeNode p, HashMap<TreeNode, Boolean> dp){
    	if(root == null)
    		return false;
    	else if(root == p){
    		dp.put(root, true);
    		return true;
    	}

    	
    	if(dp.containsKey(root))
    		return dp.get(root);
    	
    	boolean resL = isAncestor(root.left, p, dp);
    	boolean resR = isAncestor(root.right, p, dp);
    	
    	boolean res = resL || resR;
    	dp.put(root, res);
    	
    	return res;
    }
}
