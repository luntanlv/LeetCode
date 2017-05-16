import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();        
        int res  = answer.minPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        System.out.println(res);
	}
	
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        
        TreeNode cur = root;
        
        while(cur!=null || !st.empty()){
            if(cur!=null){
                st.add(cur);
                cur = cur.left;
            }
            else{
                cur = st.pop();
                res.add(cur.val);
                cur = cur.right;                
            }

        }
        return res;
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        
    }
    
    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inOrderHelper(root, res);
        return res;
    }
    
    public void inOrderHelper (TreeNode root, List<Integer> res){
        if(root == null)
            return;
        inOrderHelper(root.left, res);
        res.add(root.val);
        inOrderHelper(root.right, res);
        return;
    }
    */
    
    public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
     }

}
