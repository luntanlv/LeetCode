import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        answer.recoverTree(root);
        System.out.println(root);       
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	q.add(null);
    	List<Integer> oneLevel = new ArrayList<Integer>();
    	while(!q.isEmpty()){
    		TreeNode cur = q.poll();
    		if(cur == null){
    			res.add(oneLevel);   			
    		}
    		else{
    			oneLevel.add(cur.val);
    			q.add(cur.left);
    			q.add(cur.right);
    		}
    	}
    }
}
