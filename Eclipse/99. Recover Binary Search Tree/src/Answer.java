import java.util.Stack;

import Answer.TreeNode;

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
        answer.recoverTree(root);
        System.out.println(root);       
	}
	
    public void recoverTree(TreeNode root) {
    	TreeNode pre = null;
        TreeNode cur = root;
        TreeNode node2Switch1= null;
        TreeNode node2Switch2= null;
        Stack<TreeNode> st = new Stack<TreeNode>();
       
        while(cur!= null || !st.isEmpty()){
        	if(cur != null){
        		st.push(cur);
            	cur=cur.left;
        	}
        	else{
        		cur=st.pop();
        		if(pre!=null && pre.val>=cur.val){
        			if(node2Switch1 == null){
        				node2Switch1 = pre;
        				node2Switch2 = cur;
        			}    				
        			else
        				node2Switch2 = cur;
        		}
        		pre = cur;
        		cur = cur.right;
        	}

        }
        
        int temp = node2Switch1.val;
        node2Switch1.val = node2Switch2.val;
        node2Switch2.val = temp;
    }
}
