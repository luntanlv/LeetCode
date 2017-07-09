import java.util.ArrayList;
import java.util.List;

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
        List<Integer> res = answer.boundaryOfBinaryTree(root);
        System.out.println(res);       
	}
	
	
    //solution from JD
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    	List<Integer> res= new ArrayList<>();
    	if(root==null)
    		return res;
    	
		List<Integer> l = dfs(root.left, 1);
		List<Integer> r = dfs(root.right, 2);
		res.add(root.val);
		res.addAll(l);
		res.addAll(r);
		return res;
    }
    
    //state: 1: left boundary, 2: right boundary, 3:middle node
    private List<Integer> dfs(TreeNode root, int state){
    	if(root==null)
    		return new ArrayList<Integer>();
    	//handle middle node case, since middle node won't return node's val except the leaf node
    	if(root.left==null && root.right==null){
    		List<Integer> res =new ArrayList<Integer>();
    		res.add(root.val);
    		return res;
    	}		
    	
    	if(state==1){
    		List<Integer> l=null, r=null;
    		if(root.left !=null){
        		l = dfs(root.left, 1);
        		r = dfs(root.right, 3);    			
    		}
    		else{
    			l = new ArrayList<>();
        		r = dfs(root.right, 1);    			
    		}
    		List<Integer> res= new ArrayList<>();
    		res.add(root.val);
    		res.addAll(l);
    		res.addAll(r);
    		return res;
    	}
    	
    	else if(state ==2){
    		List<Integer> l=null, r=null;
    		if(root.right !=null){
        		l = dfs(root.left, 3);
        		r = dfs(root.right, 2); 			
    		}
    		else{		
        		l = dfs(root.left, 2);
        		r = new ArrayList<>();
    		}

    		List<Integer> res= new ArrayList<>();
    		res.addAll(l);
    		res.addAll(r);
    		res.add(root.val);
    		return res;    		
    	}
    	
    	else{
    		List<Integer> l = dfs(root.left, 3);
    		List<Integer> r = dfs(root.right, 3);
    		List<Integer> res= new ArrayList<>();
    		res.addAll(l);
    		res.addAll(r);
    		return res;    		
    	}
    }
}
