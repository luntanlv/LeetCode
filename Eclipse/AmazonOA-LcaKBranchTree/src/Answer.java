import java.util.ArrayList;
import java.util.List;

public class Answer {
    public class TreeNode {
    	int val;
    	List<TreeNode> children;
    	TreeNode(int x) { 
    		val = x; 
    		children = new ArrayList<>();
    	}
    }
    
    /*
     * 寻找公司员工的最低共同上司 其实就是Lowest Common Ancestor in a Binary Tree的变种 注意是变种！
		变化1:不是bineary tree
		变化2:ceo不是manager 如果共同上司是ceo return null
		变化3:员工可能不在这个公司 return null
     * 
     */
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        TreeNode n1 = answer.new TreeNode(1);
        TreeNode n2 = answer.new TreeNode(2);
        TreeNode n3 = answer.new TreeNode(3);
        TreeNode n4 = answer.new TreeNode(4);
        TreeNode n5 = answer.new TreeNode(5);
        TreeNode n6 = answer.new TreeNode(6);
        TreeNode n7 = answer.new TreeNode(7);
        TreeNode n8 = answer.new TreeNode(8);
        TreeNode n9 = answer.new TreeNode(9);
        TreeNode n10 = answer.new TreeNode(10);
        
        TreeNode n11 = answer.new TreeNode(11);
        
        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);
        
        n3.children.add(n5);
        
        n4.children.add(n6);
        n4.children.add(n7);
        
        n5.children.add(n8);
        
        n6.children.add(n9);
        n6.children.add(n10);
        
        TreeNode res = answer.lca(n1, n9, n7);
        int resVal = res ==null? -1:res.val;
        System.out.println(resVal);
	}
	
	public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
    	TreeNode dummy = new TreeNode(0);
    	helper(root, p, q, dummy);
    	return dummy.children.isEmpty()? null: dummy.children.get(0);		
	}
	
	private boolean[] helper(TreeNode root, TreeNode p, TreeNode q, TreeNode ca){
    	if(root == null)
    		return new boolean[2];
    	
    	boolean[] found = new boolean[2];
    	for(TreeNode child : root.children){
    		boolean[] tempFound = helper(child, p, q, ca);
    		found[0] = found[0]|tempFound[0];
    		found[1] = found[1]|tempFound[1];
    	}
    	
    	if(root==p)
    		found[0] = true;
    	if(root==q)
    		found[1] = true;
    	
    	if(found[0] && found[1] && ca.children.isEmpty()){
    		ca.children.add(root);
    	}    	
    		
    	return found;
	}
	
}
