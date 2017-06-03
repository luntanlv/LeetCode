
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
        
        int res = answer.sumNumbers(root);
        System.out.println(res);       
	}
	
    public int sumNumbers(TreeNode root) {
    	if(root == null)
    		return 0;
    	return helper_dfs(root, 0, 0);
    }
    
    private int helper_dfs(TreeNode root, int curValue, int sum){
    	int newValue = curValue*10+root.val;
    	
    	if(root.left == null && root.right ==null)
    		return sum+newValue;	
    	
    	if(root.left!=null)
    		sum = helper_dfs(root.left, newValue, sum);
    	
    	if(root.right!=null)
    		sum = helper_dfs(root.right, newValue, sum);
    	
    	return sum;
    }
    
    
    public int sumNumbers_2(TreeNode root) {

    	return helper_dfs_2(root, 0);
    }
    
    private int helper_dfs_2(TreeNode root, int curValue){
    	if(root == null)
    		return 0;
    	
    	int newValue = curValue*10+root.val;
    	if(root.left == null && root.right ==null)
    		return newValue;	
    	
    	int left = helper_dfs_2(root.left, newValue);
    	
    	int right = helper_dfs_2(root.right, newValue);
    	
    	return left+right;
    }
}
