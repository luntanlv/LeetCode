import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	List<List<Integer>> res = new ArrayList<>();
    	helper(candidates, target, new ArrayList<Integer>(), 0, 0, res);
    	return res;
    }
    
    private void helper(int[] candidatesSort, int target, List<Integer> currentList, int currentSum, int currentIndex, List<List<Integer>> res){
    	if(currentSum>target){
    		return;
    	}
    	
    	else if(currentSum == target){
    		res.add(currentList);
    	}
    	
    	for(int i=currentIndex; i<candidatesSort.length; i++){
    		List<Integer> temp = new ArrayList<Integer>(currentList);
    		temp.add(candidatesSort[i]);
    		helper(candidatesSort, target, temp, currentSum+candidatesSort[i], i, res);
    	}
    	    	
    }
}
