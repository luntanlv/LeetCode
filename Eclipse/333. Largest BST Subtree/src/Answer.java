
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
	
	//Backtacking, visit each node once, so O(n) time
    public int largestBSTSubtree(TreeNode root) {
    	int[] res = helper(root);
    	return res[1];
    }
    
    //0: isBST, 1:maxBST count So far, 2:Min val from leafs to current node, 3: Max val from leafs to current node
    private int[] helper(TreeNode root){
        if(root == null)
        	return new int[]{1,0,Integer.MAX_VALUE,Integer.MIN_VALUE};
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        //BST
        if( (left[0]>0 && root.val>left[3]) && (right[0]>0 && root.val<right[2]) ){
        	return new int[]{1, left[1] + right[1] +1, Math.min(root.val, left[2]), Math.max(root.val,right[3])};
        }
        //Not BST, Max and Min doesn't matter anymore, set to 0 here.
        else
        	return new int[]{0, Math.max(left[1], right[1]),0,0}; 	
    }
    
//    private int[] helper(TreeNode root){
//        if(root.left==null && root.right==null)
//        	return new int[]{1,1,root.val,root.val};
//        
//        int[] left = root.left != null? helper(root.left) : new int[]{1,0,Integer.MAX_VALUE,Integer.MIN_VALUE};
//        int[] right = root.right !=null? helper(root.right) : new int[]{1,0,Integer.MAX_VALUE,Integer.MIN_VALUE};
//        
//        if( (left[0]>0 && root.val>left[3]) && (right[0]>0 && root.val<right[2]) ){
//        	return new int[]{1, left[1] + right[1] +1, Math.min(root.val, left[2]), Math.max(root.val,right[3])};
//        }
//        else
//        	return new int[]{0, Math.max(left[1], right[1]),0,0}; 	
//    }
}
