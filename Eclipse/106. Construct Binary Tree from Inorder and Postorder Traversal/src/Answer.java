
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
//        int[] inorder = new int[]{4,2,5,1,6,3,7};
//        int[] preorder = new int[]{1,2,4,5,3,6,7};
        
        int[] inorder = new int[]{2,1};
        int[] postorder = new int[]{2,1};
        TreeNode res = answer.buildTree(inorder, postorder);
        System.out.println(res);       
	}
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	TreeNode res = buildTreeHelper(inorder, postorder, 0, inorder.length-1, postorder.length-1);
    	return res;
    }
    
    public TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderEnd) {
    	if(inorderStart>inorderEnd)
    		return null;   	
    	
        int rootVal = postorder[postorderEnd];
        TreeNode root = new TreeNode(rootVal);
        
    	int rootIndexInInorder=0;
    	for(int i=inorderStart; i<=inorderEnd; i++){
    		if(inorder[i]==rootVal)
    			rootIndexInInorder = i;
    	}
    	
    	TreeNode right = buildTreeHelper(inorder, postorder, rootIndexInInorder+1, inorderEnd, postorderEnd-1);
    	TreeNode left = buildTreeHelper(inorder, postorder, inorderStart, rootIndexInInorder-1, postorderEnd-1-(inorderEnd-rootIndexInInorder));
    	
    	root.left = left;
    	root.right = right;
    	
    	return root;
    }
}
