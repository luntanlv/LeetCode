
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
        int[] nums = new int[]{1,2,3,4,5,6,7};

        TreeNode res = answer.sortedArrayToBST(nums);
        System.out.println(res);       
	}
	
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int start, int end){
    	if(start>end)
    		return null;
    	int mid = (start + end)/2;
    	TreeNode newRoot = new TreeNode(nums[mid]);
    	TreeNode left = helper(nums, start, mid-1);
    	TreeNode right = helper(nums, mid+1, end);
    	
    	newRoot.left = left;
    	newRoot.right =right;
    	
    	return newRoot;
    }
}
