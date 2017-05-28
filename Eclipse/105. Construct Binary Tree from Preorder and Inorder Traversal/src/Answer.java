import java.util.Arrays;

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
        int[] preorder = new int[]{1,2};
        TreeNode res = answer.buildTree(preorder, inorder);
        System.out.println(res);       
	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder.length==0 || inorder.length==0)
    		return null;
    	
    	if(preorder.length==1)
    		return new TreeNode(preorder[0]);
    	
    	int rootVal = preorder[0];
    	TreeNode root = new TreeNode(rootVal);
    	int rootIndexInInorder=0;
    	for(int i=0; i<inorder.length; i++){
    		if(inorder[i]==rootVal)
    			rootIndexInInorder = i;
    	}
    	
    	int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndexInInorder);
    	int[] inorderRight = Arrays.copyOfRange(inorder, rootIndexInInorder+1, inorder.length);
    	int[] preorderLeft = Arrays.copyOfRange(preorder, 1, 1+inorderLeft.length);
    	int[] preorderRight = Arrays.copyOfRange(preorder, 1+inorderLeft.length, 1+inorderLeft.length+inorderRight.length);
    	
    	TreeNode left = buildTree(preorderLeft, inorderLeft);
    	TreeNode right = buildTree(preorderRight, inorderRight);
    	
    	root.left = left;
    	root.right = right;
    	
    	return root;
    }
    
    
    //No copy
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
