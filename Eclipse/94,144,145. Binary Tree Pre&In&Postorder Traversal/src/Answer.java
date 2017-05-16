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
	
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        
        TreeNode cur = root;
        while(cur!=null || !st.empty()){
        	if(cur != null){
            	res.add(cur.val);
            	st.push(cur);
            	cur = cur.left;
        	}
        	else{
        		cur=st.pop().right;
        	}

        }
        return res;
        
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
    
    //Using helper stack to tracking stacking visiting status
    //0:haven't visit left; 1:visted left
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        Stack<Integer> vst = new Stack<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        
        st.push(root);
        vst.push(0);
        
        while(!st.empty()){
        	TreeNode cur = st.pop();
        	int vcur = vst.pop();
        	if(cur==null){
        		continue;
        	}
        	
        	if(vcur==0){
        		st.push(cur);
        		vst.push(1);
        		
        		st.push(cur.left);
        		vst.push(0);
        	}
        	else if(vcur==1){
        		res.add(cur.val);
        		st.push(cur.right);
        		vst.push(0);
        	}
        }
        return res;
    }    
    
    
    //Using helper stack to tracking stacking visiting status
    //0:haven't visit left; 1:visted left haven't visit right; 2: visted both
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        Stack<Integer> vst = new Stack<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        
        st.push(root);
        vst.push(0);
        
        while(!st.empty()){
        	TreeNode cur = st.pop();
        	int vcur = vst.pop();
        	if(cur==null){
        		continue;
        	}        	
        }
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
