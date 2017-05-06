import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        List<List<Integer>> res = answer.permute(new int[]{1,2,3});
        for(List<Integer> oneList : res){
        	System.out.println(oneList);
        }
        
	}
	
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	res.add(new ArrayList<Integer>());
    	for(int i=0;i<nums.length;i++){      	
        	ArrayList<List<Integer>> tempRes = new ArrayList<List<Integer>>();   
        	
        	for(List<Integer> oneList : res){
        		
        		for(int item: nums){
        			if(!oneList.contains(item)){
        				List<Integer> tempOneList = new ArrayList<Integer>(oneList);
        				tempOneList.add(item);
        				tempRes.add(tempOneList);
        			}
        		}
        	}
        	res = tempRes;    		
    	}
    	return res;

    }
}
