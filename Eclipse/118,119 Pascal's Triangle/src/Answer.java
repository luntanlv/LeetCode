import java.util.ArrayList;
import java.util.List;


public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        
        //List<List<Integer>> res = answer.generate(6);
        List<Integer> res = answer.getRow(5);
        System.out.println(res);       
	}
	
	//118
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
    
    //119
    //return rowIndex'th row
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> res = new ArrayList<Integer>();
    	List<Integer> preList = new ArrayList<Integer>();
    	
    	for(int i=0; i<=rowIndex; i++){
    		List<Integer> temp = preList;
    		preList = res;
    		res=temp;
    		res.clear();
    		
    		int pre=0;
    		for(int j=0; j<i; j++){
				int cur = preList.get(j);
				res.add(pre+cur);
				pre = cur;	
    		}
    		res.add(1);
    	}
        return res;
    }
    
    public List<Integer> getRow_better(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i = 0; i<=rowIndex; i++) {
        	res.add(1);
    		for(int j=i-1;j>0;j--) {
    			res.set(j, res.get(j-1)+res.get(j));
    		}
        }
        return res;
    }
}
