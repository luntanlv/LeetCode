import java.util.Stack;

public class Answer {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}	

	//http://www.javaworld.com/article/2077424/learn-java/does-java-pass-by-reference-or-pass-by-value.html
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        TreeNode root = answer.new TreeNode(0);
        TreeNode node1 = answer.new TreeNode(1);
        TreeNode node2 = answer.new TreeNode(2);
        TreeNode node3 = answer.new TreeNode(3);
        
        root.left = node1;
        root.right = node2;
        node2.right = node3;
        
        Codec codec = answer.new Codec();
        String res = codec.serialize(root);
        TreeNode res1 = codec.deserialize(res);
        System.out.println(res);       
	}
	
	public class Codec {

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        Stack<TreeNode> st = new Stack<TreeNode>();
	        StringBuilder sb = new StringBuilder();
	        
	        TreeNode cur = root;
	        
	        while(cur!=null || !st.isEmpty()){
	        	if(cur==null){
	        		sb.append("X,");
	        		cur = st.pop().right;
	        		continue;
	        	}
	        	
	        	sb.append(cur.val+",");
	        	st.push(cur);
	        	cur = cur.left;
	        }
	        sb.append("X");
	        return sb.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	    	String[] dataList = data.split(",");
	    	
	        Stack<TreeNode> st = new Stack<TreeNode>();
	        TreeNode dummyRoot = new TreeNode(0);
	        TreeNode pra = dummyRoot;
	        boolean isrightChild =false;
	        for(String dataStr: dataList){
	        	//'X'
	        	if(dataStr.equals("X")){
	        		if(st.isEmpty())
	        			break;
	        		pra = st.pop();
	        		isrightChild = true;
	        	}        	
	        	else{
	        		int val = Integer.valueOf(dataStr);
	        		TreeNode newNode = new TreeNode(val);
	        		st.push(newNode);
	        		
	        		if(!isrightChild){
	        			pra.left = newNode;
	        			
	        		}	
	        		else if(isrightChild){
	        			pra.right = newNode;
	        			isrightChild = false;
	        		}
	        		pra = newNode;
	        	}
	        }
	        return dummyRoot.left;
	    }
	}
}
