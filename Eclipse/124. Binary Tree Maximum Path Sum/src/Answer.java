
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
        
        int res = answer.maxPathSum(root);
        System.out.println(res);       
	}
    
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        dfs(root, max);
        return max[0];
    }
    
    //max[0] store the max so far
    private int dfs(TreeNode cur, int[] max){
    	if(cur == null)
    		return 0;
    	
    	int left = dfs(cur.left, max);
    	left = left<0? 0 : left;
    	int right = dfs(cur.right, max);
    	right = right<0? 0 : right;
    	
    	max[0] = Math.max(left+right+cur.val, max[0]);
    	return Math.max(left, right) +cur.val;
    }
}
