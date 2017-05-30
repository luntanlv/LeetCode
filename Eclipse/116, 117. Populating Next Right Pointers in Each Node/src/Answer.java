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
        answer.connect_117(root);
        System.out.println(root);       
	}
	
	//116
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
    
    //16
    //O(1) space
    public void connect_116_2(TreeLinkNode root) {
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
    
    //117
    public void connect_117(TreeLinkNode root) {
    	TreeLinkNode levelStarting = root;
    	
    	while(levelStarting != null){
        	TreeLinkNode cur = levelStarting;
        	int offset =1;
        	while(cur!=null){
        		
        		if(cur.left != null){
        			cur.left.next = getNext(levelStarting, offset);
        			offset++;
        		}      			
        		
        		if(cur.right !=null){
        			cur.right.next = getNext(levelStarting, offset);
        			offset++;
        		}

        		cur=cur.next;
        	}
        	levelStarting = getNext(levelStarting, 0);
    	}	
    }
    
    private TreeLinkNode getNext(TreeLinkNode root, int offset){
    	TreeLinkNode next = null;
    	TreeLinkNode cur = root;
    	while(cur!= null){
    		if(cur.left != null){  			
    			if(offset ==0){
        			next=cur.left;
        			break;
    			}
    			offset--;
    		}
    		else if(cur.right != null){
    			if(offset ==0){
        			next = cur.right;
        			break;
    			}    			
    			offset--;
    		}
    		cur=cur.next;
    	}
    	return next;
    }
}
