import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();  
        System.out.println();
	}	
	
	//39
    public List<List<Integer>> combinationSum39(int[] candidates, int target) {
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
    public List<List<Integer>> combinationSum40(int[] candidates, int target) {
    	//Arrays.sort(candidates);
    	List<List<Integer>> res = new ArrayList<>();
    	helper40(candidates, target, new ArrayList<Integer>(), 0, 0, res);
    	return res;
    }
    
    private void helper40(int[] candidatesSort, int target, List<Integer> currentList, int currentSum, int currentIndex, List<List<Integer>> res){
    	if(currentSum>target){
    		return;
    	}
    	
    	else if(currentSum == target){
    		res.add(currentList);
    	}
    	
    	for(int i=currentIndex; i<candidatesSort.length; i++){
    		List<Integer> temp = new ArrayList<Integer>(currentList);
    		temp.add(candidatesSort[i]);
    		helper40(candidatesSort, target, temp, currentSum+candidatesSort[i], i, res);
    	}    	
    }    
}
