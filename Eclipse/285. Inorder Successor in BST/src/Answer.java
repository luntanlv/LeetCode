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
        
        TreeNode res = answer.inorderSuccessor(root, root);
        System.out.println(res);       
	}
	
	//Leverage BST
	//Better
	//Whenever you go left the current root is the new possible successor, otherwise the it remains the same.
	/*
	 * The idea is to compare root's value with p's value if root is not null, and consider the following two cases:
	 * root.val > p.val. In this case, root can be a possible answer, so we store the root node first and call it res. 
	 * 		However, we don't know if there is anymore node on root's left that is larger than p.val. So we move root to its left and check again.
	 * 
	 * root.val <= p.val. In this case, root cannot be p's inorder successor, neither can root's left child. 
	 * 		So we only need to consider root's right child, thus we move root to its right and check again.
	 * 
	 */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    	TreeNode cur = root, suc = null;
    	while(cur != null){
    		if(cur.val>p.val){
    			suc = cur;
    			cur = cur.left;   			
    		}
    		//cur.val<=p.val, when cur.val = p.val, cur = cur.right, all cur.val > p.val, so it keep move to left till null, so we still get suc
    		else{
    			cur = cur.right;
    		}

    	}
    	return suc;
    }
	
	//Leverage BST
    public TreeNode inorderSuccessor_notBetter(TreeNode root, TreeNode p) {
    	TreeNode cur = root;
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	while(cur != null){
    		if(cur.val>p.val){
    			st.push(cur);
    			cur = cur.left;   			
    		}
    		else if(cur.val<p.val){
    			st.push(cur);
    			cur = cur.right;
    		}
    		else{
    			if(cur.right != null){
    				cur = cur.right;
    				TreeNode pre =null; 
    				while(cur!=null){
    					pre = cur;
    					cur = cur.left;
    				}
    				return pre;
    			}
    			else{
        			while(!st.isEmpty() && cur==st.peek().right){
        				cur = st.pop();
        			}
        			return st.isEmpty()? null : st.pop();
    			}
    		}
    	}
    	return null;
    }
	
    //Also recursion
    //Successor

    public TreeNode successor(TreeNode root, TreeNode p) {
      if (root == null)
        return null;

      if (root.val <= p.val) {
        return successor(root.right, p);
      } else {
        TreeNode left = successor(root.left, p);
        return (left != null) ? left : root;
      }
    }
    //Predecessor

    public TreeNode predecessor(TreeNode root, TreeNode p) {
      if (root == null)
        return null;

      if (root.val >= p.val) {
        return predecessor(root.left, p);
      } else {
        TreeNode right = predecessor(root.right, p);
        return (right != null) ? right : root;
      }
    }
    
	//Do a inorder trversal, general solution, not for BST
    public TreeNode inorderSuccessor_NotBst(TreeNode root, TreeNode p) {
    	TreeNode cur = root, res = null;
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	boolean vistedP = false;
    	while(cur!=null || !st.isEmpty()){
    		if(cur != null){
        		st.push(cur);
        		cur = cur.left;	
    		}
    		else{    		
    			cur = st.pop();
				
    			if(cur == p){
    				vistedP = true;
    			}
    			else if(vistedP){
    				res=cur;
    				break;
    			}
    			
    			cur=cur.right;
    		}	
    	}
    	
    	return res;
    }
}
