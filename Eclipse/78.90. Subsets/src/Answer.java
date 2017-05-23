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
	
	//78
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
    
	//loop by length of the res
	//[] ->[],[1],[2],[3] -> [],[1],[2],[3],[1,2],[1,3],[2,3]
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
    
    //loop by adding each item
    //[] -> [], [1] -> [],[1], [2],[1,2] -> [],[1],[2],[1,2] [3],[1,3],[2,3],[1,2,3] 
    public List<List<Integer>> subsets3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        
        for(int i =0; i<nums.length; i++){
        	
        	int startOfPreLevel = 0;
            int lenOfPreLevel = res.size();
        	
        	for(int j= startOfPreLevel; j<lenOfPreLevel; j++){
        		List<Integer> oneList = res.get(j);
        		List<Integer> newList = new ArrayList<Integer>(oneList);
    			newList.add(nums[i]);
    			res.add(newList);      		
        	}
        }
        return res;        
    }
    
    
    //90
    //having dup
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtrackWithDup(list, new ArrayList<Integer>(), nums, 0);
        return list;
        
    }
    
	private void backtrackWithDup(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    
	    int pre=0;
	    for(int i = start; i < nums.length; i++){
	    	if(i!=start && nums[i]==pre)
	    		continue;
	    	
	    	pre=nums[i];
	    	
	        tempList.add(nums[i]);
	        backtrackWithDup(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
	
    //loop by adding each item
	//[1,2,3,4]
    //[] -> [], [1] -> [],[1], [2],[1,2] -> [],[1],[2],[1,2],  [3],[1,3],[2,3],[1,2,3] ->[],[1],[2],[1,2], [3],[1,3],[2,3],[1,2,3],  [3,3],[1,3,3],[2,3,3],[1,2,3,3] 
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());

    	int startOfPreLevel = 0;
        int lenOfPreLevel = res.size();
        
        for(int i =0; i<nums.length; i++){
        	
        	//not an dup item
        	if(i==0 || nums[i] != nums[i-1]){
        		startOfPreLevel = 0;
        		lenOfPreLevel = res.size();
        	}
        	//dup item, just add dup item to only last set
        	else{
        		startOfPreLevel = lenOfPreLevel;
        		lenOfPreLevel = res.size();
        	}
        	
        	for(int j= startOfPreLevel; j<lenOfPreLevel; j++){
        		List<Integer> oneList = res.get(j);
        		List<Integer> newList = new ArrayList<Integer>(oneList);
    			newList.add(nums[i]);
    			res.add(newList);      		
        	}
        }
        return res;        
    }
}
