
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
	
	//divide and concour
    public int largestBSTSubtree(TreeNode root) {
    	int[] res = helper(root);
    	return res[1];
    }
    
    //0: isBST, 1:maxBST So far
    private int[] helper(TreeNode root){
        if(root==null)
        	return new int[]{1,0};

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        int leftVal = root.left == null ? Integer.MIN_VALUE: root.left.val;
        int rightVal = root.right == null? Integer.MAX_VALUE: root.right.val;
        
        if(left[0]>0 && right[0]>0 && root.val>leftVal && root.val<rightVal){
        	return new int[]{1, left[1] + right[1] +1};
        }
        else
        	return new int[]{0, Math.max(left[1], right[1])}; 	
    }
}
