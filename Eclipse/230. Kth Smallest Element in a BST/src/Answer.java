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
	
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        TreeNode cur=root;
        while(cur!=null || !st.isEmpty()){
        	if(cur!=null){
        		st.push(cur);
        		cur=cur.left;
        	}
        	else{
        		cur = st.pop();
        		k--;
        		if(k==0)
        			break;		
        		cur=cur.right;
        	}
        }
        
        return cur.val;
    }
}
