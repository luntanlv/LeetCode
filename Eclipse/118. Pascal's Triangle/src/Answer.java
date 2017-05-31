import java.util.ArrayList;
import java.util.List;


public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        
        List<List<Integer>> res = answer.generate(6);
        System.out.println(res);       
	}
	
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	if(numRows == 0)
    		return res;
    	
    	for(int i=1; i<=numRows; i++){
    		List<Integer> newLevel = new ArrayList<Integer>();
    		int pre=0;

    		for(int j=0; j<i-1;j++){
        		List<Integer> lastLevel = res.get(res.size()-1);
				int cur = lastLevel.get(j);
				newLevel.add(pre+cur);
				pre = cur;	
    		}
    		newLevel.add(1);
    		res.add(newLevel);
    	}
    	return res;
    }
    
}
