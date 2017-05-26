import java.util.List;

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
        int res = answer.maxDepth(root);
        System.out.println(res);       
	}
	
    public int maxDepth(TreeNode root) {
    	int res = dfsHepler(root, 1);
    	return res;
    }
    
    private int dfsHepler(TreeNode root, int height){
    	if(root==null)
    		return height-1;
    	
    	int l = dfsHepler(root.left, height+1);
    	int r = dfsHepler(root.right, height+1);
    	
    	return Math.max(l, r);
    }
}
