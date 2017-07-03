import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        List<List<Integer>> res = answer.permuteUnique(new int[]{0,1,0,0,9});
        for(List<Integer> oneList : res){
        	System.out.println(oneList);
        }
        
	}
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, new HashSet<Integer>(), res, new ArrayList<Integer>());
        return res;
    }
    
    private void backtracking (int[] nums, HashSet<Integer> usedIndex, List<List<Integer>> res, List<Integer> cur){
    	if(cur.size()==nums.length){
    		res.add(new ArrayList<Integer>(cur));
    		return;
    	}
    	
    	int pre = 0;
    	boolean havePre = false;
    	for(int i=0; i<nums.length; i++){
    		if(!usedIndex.contains(i)  && (!havePre || nums[i] != pre)){
    			cur.add(nums[i]);
    			usedIndex.add(i);
    			
    			backtracking(nums, usedIndex, res, cur);
    			
    			cur.remove(cur.size()-1);
    			usedIndex.remove(i);
    			pre = nums[i];
    			havePre = true;
    		}	
    	}
    }
}
