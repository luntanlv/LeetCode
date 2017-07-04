import java.util.LinkedList;
import java.util.Queue;

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
        int res = answer.largestBSTSubtree(root);
        System.out.println(res);       
	}
	
	//Right to left BFS
    public int findBottomLeftValue(TreeNode root) {
    	if(root==null)
    		return -1;
    	
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        TreeNode cur=null;
        
        while(!q.isEmpty()){
        	cur = q.poll();
        	if(cur.right!=null)
        		q.add(cur.right);
        	
        	if(cur.left!=null)
        		q.add(cur.left);
        }
        return cur.val;
    }
}
