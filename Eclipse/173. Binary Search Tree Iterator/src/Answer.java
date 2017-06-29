import java.util.Stack;

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
        
        boolean res = answer.isBalanced(root);
        System.out.println(res);       
	}
	
	public class BSTIterator {

		private Stack<TreeNode> st;
		
		private void processLeft(TreeNode root){
			TreeNode cur = root;
			while(cur!=null){
				st.push(cur);
				cur = cur.left;
			}
		}
		
	    public BSTIterator(TreeNode root) {
	        st = new Stack<TreeNode>();
	        processLeft(root);
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !st.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	    	TreeNode cur = st.pop();
	    	processLeft(cur.right);
	    	return cur.val;
	    }
	}
}
