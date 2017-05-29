import java.util.ArrayList;
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
        TreeNode root = answer.new TreeNode(1);
        
        boolean res = answer.hasPathSum(root,3);
        System.out.println(res);       
	}
	
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null)
    		return false; 
    	
    	if(root.left == null && root.right == null)
    		return sum - root.val == 0;
       
        boolean res_l = hasPathSum(root.left, sum-root.val);
        boolean res_r = hasPathSum(root.right, sum-root.val);
        
        return res_l || res_r;
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	pathSumHelper(root, sum, res, new ArrayList<Integer>());
    	return res;
    }
    
    public void pathSumHelper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> cur) {
        if(root == null)
        	return;
        
    	if(root.left == null && root.right == null){
        	if(sum - root.val==0){
        		cur.add(root.val);
        		res.add(new ArrayList<Integer>(cur));
        		cur.remove(cur.size()-1);
        	}
        		
        	return;
    	}

              
        cur.add(root.val);
        pathSumHelper(root.left, sum-root.val, res, cur);
        pathSumHelper(root.right, sum-root.val, res, cur);
        cur.remove(cur.size()-1);
    }
}
