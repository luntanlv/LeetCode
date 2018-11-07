import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();  
        System.out.println();
	}	
	
	//39
    public List<List<Integer>> combinationSum39(int[] candidates, int target) {
    	//We need sort and currentIndex to prevent dup result
    	Arrays.sort(candidates);
    	List<List<Integer>> res = new ArrayList<>();
    	helper39(candidates, target, new ArrayList<Integer>(), 0, 0, res);
    	return res;
    }
    
    private void helper39(int[] candidatesSort, int target, List<Integer> currentList, int currentSum, int currentIndex, List<List<Integer>> res){
    	if(currentSum>target){
    		return;
    	}
    	
    	else if(currentSum == target){
    		res.add(currentList);
    	}
    	
    	for(int i=currentIndex; i<candidatesSort.length; i++){
    		List<Integer> temp = new ArrayList<Integer>(currentList);
    		temp.add(candidatesSort[i]);
    		helper39(candidatesSort, target, temp, currentSum+candidatesSort[i], i, res);
    	}    	
    }
    
    //40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
     }

     private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {

        if(remain < 0) return; /** no solution */
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
           for (int i = start; i < cand.length; i++) {
              if(i > start && cand[i] == cand[i-1]) continue; /** skip duplicates */
              tempList.add(cand[i]);
              backtrack(list, tempList, cand, remain - cand[i], i+1);
              tempList.remove(tempList.size() - 1);
           }
        }
     }   
}
