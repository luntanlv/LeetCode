import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{1,2,3};
        List<List<Integer>> res = answer.subsets(input);
        
        for(List<Integer> oneList: res){
        	for(int val: oneList)
        		System.out.print(val + ", ");
        	System.out.println("");
        }
            
	}
	
	//Backtracking
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
    
	

	//
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        
    	int startOfPreLevel = 0;
        int lenOfPreLevel = res.size();
        
        Arrays.sort(nums);
        
        for(int i =0; i<nums.length; i++){
            
            for(int j=startOfPreLevel; j<lenOfPreLevel; j++){
            	List<Integer> oneList = res.get(j);
            	int lastNum = oneList.isEmpty()? Integer.MIN_VALUE: oneList.get(oneList.size()-1);
            	
            	for( int num : nums){
            		if(num>lastNum){
            			List<Integer> newList = new ArrayList<Integer>(oneList);
            			newList.add(num);
            			res.add(newList);
            		}
            	}
            	
            }     
            startOfPreLevel=lenOfPreLevel;
            lenOfPreLevel = res.size();   
        }
        return res;
    }
}
