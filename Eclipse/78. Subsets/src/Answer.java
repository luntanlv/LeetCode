import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        
        List<List<Integer>> res = answer.combine(20,16);
        
        for(List<Integer> oneList: res){
        	for(int val: oneList)
        		System.out.print(val + ", ");
        	System.out.println("");
        }
            
	}
	
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        
        for(int i =0; i<nums.length; i++){
        	int startOfPreLevel = 0;
            int lenOfPreLevel = res.size();
            
            for(int j=startOfPreLevel; j<lenOfPreLevel; j++){
            	List<Integer> oneList = res.get(j);
            	
            	for( int num : nums){
            		if(!oneList.contains(num)){
            			List<Integer> newList = new ArrayList<Integer>(oneList);
            			newList.add(num);
            			res.add(newList);
            		}
            	}
            	
            }   	
        }
        
    }
}
