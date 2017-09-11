
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
        System.out.println();
	}
	
	//I saw the solution
	public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }

        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
