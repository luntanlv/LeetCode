public class Answer {
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
	
    /*
     * Given a list of unique integers, construct the binary tree by given order without rebalancing, then find out the distance between two nodes.
     * ��һ������ A[5,6,3,1,2,4],�Ƚ��� BST,Ȼ���������� node ֮��ľ��롣
		��֪��һ��Ԫ�� 5 �� root,ʣ�µ��������!!ע������п������������ȳ���(6,��Ӧ root-5),
		Ҳ�п������������ȳ���(1,2,��Ӧ root-3)!
		����� node �����ڵĻ�,����-1;
     */
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        //int[] input = new int[]{5,6,3,1,2,4};
        int[] input = new int[]{5};
        int res = answer.bstDistance(input, 5,1);
        System.out.println(res);
	}
	
	public int bstDistance(int[] values, int node1, int node2){
		if(values.length<1)
			return -1;
		
		//Build BST
		TreeNode root = createBst(values);
		int l1=pathLen(root, node1);
		int l2=pathLen(root, node2);
		int cl=lowestComAn(root, node1, node2);
		return l1<0||l2<0||cl<0? -1 : l1+l2-2*cl;
		
	}
	
	//Arrays.sort(values);
//	public TreeNode createBst(int[] values, int start, int end){
//    	if(start>end)
//    		return null;
//    	int mid = (start + end)/2;
//    	TreeNode newRoot = new TreeNode(values[mid]);
//    	TreeNode left = createBst(values, start, mid-1);
//    	TreeNode right = createBst(values, mid+1, end);
//    	
//    	newRoot.left = left;
//    	newRoot.right =right;
//    	
//    	return newRoot;
//	}
	
	public TreeNode createBst(int[] values){
		TreeNode root = new TreeNode(values[0]);
		for(int i=1; i<values.length; i++){
			createBstHelper(root, values[i]);
		}
		return root;
	}
	
	public void createBstHelper(TreeNode root, int val){
		if(val<root.val){
			if(root.left == null){
				root.left = new TreeNode(val);
			}
			else{
				createBstHelper(root.left, val);
			}
		}
		else{
			if(root.right == null){
				root.right = new TreeNode(val);
			}
			else{
				createBstHelper(root.right, val);
			}
		}
	}
	
	public int pathLen(TreeNode root, int tar){
		TreeNode cur = root;
		int count=0;
		while(cur!=null){
			if(cur.val==tar)
				return count;
			
			if(tar<cur.val)
				cur=cur.left;
			else
				cur=cur.right;
			
			count++;				
		}
		return -1;
	}
	
	public int lowestComAn(TreeNode root, int node1, int node2){
		int count=0;
		TreeNode cur = root;
		while(cur!=null){
			if(node1<cur.val && node2<cur.val){
				cur=cur.left;
				count++;
			}
			else if(node1>cur.val && node2>cur.val){
				cur=cur.right;
				count++;
			}
			else
				break;		
		}
		return count;
		
	}
}
