import java.util.LinkedList;
import java.util.Queue;

public class Answer {
    public class TreeLinkNode {
    	int val;
    	TreeLinkNode left;
    	TreeLinkNode right;
    	TreeLinkNode next;
    	TreeLinkNode(int x) { val = x; }
    }
    
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        TreeLinkNode root = answer.new TreeLinkNode(2);
        TreeLinkNode left = answer.new TreeLinkNode(1);
        TreeLinkNode right = answer.new TreeLinkNode(3);
        root.left=left;
        root.right= right;
        answer.connect(root);
        System.out.println(root);       
	}
	
	
	//Not O(1) space
    public void connect(TreeLinkNode root) {
    	if(root==null)
    		return;
    	
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            int levelSize = q.size();
            TreeLinkNode pre = null;
            for(int i=0; i<levelSize; i++){
            	TreeLinkNode cur =  q.poll();
            	if(pre != null){
            		pre.next = cur;
            	}
            	pre = cur;
            	if(cur.left != null)
            		q.add(cur.left);
            	if(cur.right != null)
            		q.add(cur.right);
            }
            pre.next = null;        	
        }
    }
    
    //O(1) space
    public void connect_2(TreeLinkNode root) {
    	if(root==null)
    		return;
    	
    	TreeLinkNode levelStarting = root;
    	
    	while(levelStarting.left != null){
        	TreeLinkNode par = levelStarting;
        	while(par!=null){
        		par.left.next = par.right;
        		if(par.next != null)
        			par.right.next = par.next.left;
        		else
        			par.right.next = null;
            	par=par.next;
        	}
        	levelStarting = levelStarting.left;
    	}	
    }
}
