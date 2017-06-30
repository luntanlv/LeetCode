
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
        
        int res = answer.closestValue(root, 0.9);
        System.out.println(res);       
	}
	
    public int closestValue(TreeNode root, double target) {
    	TreeNode cur = root;
    	int res =root.val;
    	while(cur!=null){
    		double dif = target - cur.val;
    		if( Math.abs(dif) < Math.abs(target - res) )
    			res = cur.val;
    		
    		if(dif > 0)
    			cur=cur.right;
    		else if(dif < 0)
    			cur =cur.left;
    		else
    			break;
    	}
    	
    	return res;
    }
}
