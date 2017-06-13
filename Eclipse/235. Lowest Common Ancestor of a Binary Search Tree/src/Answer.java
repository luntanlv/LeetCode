import java.util.HashMap;

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
        TreeNode node1 = answer.new TreeNode(0);
        TreeNode node2 = answer.new TreeNode(2);
        TreeNode node3 = answer.new TreeNode(3);
        
        root.left = node1;
        root.right = node2;
        node2.right = node3;
        
        TreeNode res = answer.lowestCommonAncestor(root, node1, node3);
        System.out.println(res.val);       
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	TreeNode cur = root;
    	while(cur!= null){
    		if(p.val<cur.val && q.val<cur.val)
    			cur= cur.left;
    		else if(p.val>cur.val && q.val>cur.val)
    			cur= cur.right;
    		else
    			break;
    	}
    	return cur;   	
    }
	

}
