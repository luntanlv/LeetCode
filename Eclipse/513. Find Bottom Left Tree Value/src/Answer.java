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
        int res = answer.findBottomLeftValue(root);
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
    
    //DFS
    public int findBottomLeftValue_dfs(TreeNode root) {
        if(root==null)
            return 0;
        int[] result = {root.val, 0};
        helper(root, 0, result);
        return result[0];
    }
    
    private void helper(TreeNode root, int row, int[] result/*result-val, lowest row*/ ){
        if(root==null)
            return;
        
        if(row > result[1]){
            result[0] = root.val;
            result[1] = row;
        }
        
        helper(root.left, row+1, result); //no need to care about the cols of a row, as here we always go to left first, the left-most node of a row will always be captured first 
        helper(root.right, row+1, result);
    }

}
