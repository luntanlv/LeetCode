import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Answer.TreeNode;

public class Answer {
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
    
    //Morris Preoder Traverdal
    //O(1) space
    //http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
    public List<Integer> preorderTraversal_Morris(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();       
        TreeNode cur = root;
        
        while(cur!=null){
        	
        	if(cur.left != null){
        		TreeNode preNode = cur.left;
        		while(preNode.right != null && preNode.right != cur){
        			preNode = preNode.right;
        		}
        		
        		if(preNode.right == null){
        			res.add(cur.val);
        			preNode.right = cur;
        			cur=cur.left;
        		}       			
        		else{
        			preNode.right = null;
        			cur=cur.right;
        		}
        	}
        	else{
        		res.add(cur.val);
        		cur = cur.right;
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
    
    //OTHER solution: https://discuss.leetcode.com/topic/2919/my-accepted-code-with-explaination-does-anyone-have-a-better-idea
    
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
    
    //Morris Inoder Traverdal
    //O(1) space
    //http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
    public List<Integer> inorderTraversal_Morris(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();       
        TreeNode cur = root;
        
        while(cur!=null){
        	
        	if(cur.left != null){
        		TreeNode preNode = cur.left;
        		while(preNode.right != null && preNode.right != cur){
        			preNode = preNode.right;
        		}
        		
        		if(preNode.right == null){
        			preNode.right = cur;
        			cur=cur.left;
        		}       			
        		else{
        			preNode.right = null;
        			res.add(cur.val);
        			cur=cur.right;
        		}
        	}
        	else{
        		res.add(cur.val);
        		cur = cur.right;
        	}
        }
        return res;
    }
    
    
    
    //PostOrder
    // Reverse the process of preorder
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        
        TreeNode cur = root;
        
        while(cur!=null || !st.empty()){
        	if(cur!= null){
        		res.add(0, cur.val);
        		st.push(cur);
        		cur=cur.right;
        	}
        	else{
        		cur= st.pop().left;
        	}
        }
        
        return res;
        
    }
    
    //Using helper stack to tracking stacking visiting status
    //0:haven't visit left; 1:visted left haven't visit right; 2: visted both
    public List<Integer> postorderTraversal2(TreeNode root) {
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
        	
        	//0:haven't visit left;
        	if(vcur ==0){
        		st.push(cur);
        		vst.push(1);
        		st.push(cur.left);
        		vst.push(0);   		
        	}
        	//1:visted left haven't visit right;
        	else if(vcur == 1){
        		st.push(cur);
        		vst.push(2);
        		st.push(cur.right);
        		vst.push(0);           		
        	}
        	//2:visted both left and right
        	else if(vcur == 2){
        		res.add(cur.val);         		
        	}        	
        	
        }
        return res;
    }
    
    //Morris Postoder Traverdal
    //O(1) space
    //http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
    public List<Integer> postorderTraversal_Morris(TreeNode root) {

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
