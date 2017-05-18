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
	
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res = new ArrayList<List<Integer>> ();
    	
    	for(int i=0; i<k; i++){
    		if(i==0){  			
    			for(int j=1; j<=n; j++){
    				List<Integer> temp = new ArrayList<Integer>();
    				temp.add(j);
    				res.add(temp);
    			}
    		}
    		else{
    			List<List<Integer>> resTemp = new ArrayList<List<Integer>>();
    			while(!res.isEmpty()){
    				int lastListIndex = res.size()-1;
    				List<Integer> oneList = res.get(lastListIndex);
    				res.remove(lastListIndex);
    				
    				int last= oneList.get(oneList.size()-1);
        			for(int j=last+1; j<=n; j++){  
        				List<Integer> newList = new ArrayList<Integer>(oneList);
        				newList.add(j);
        				resTemp.add(newList);
        			}   
    				
    			}
//    			for(List<Integer> oneList: res){
//    				int last= oneList.get(oneList.size()-1);
//        			for(int j=last+1; j<=n; j++){  
//        				List<Integer> newList = new ArrayList<Integer>(oneList);
//        				newList.add(j);
//        				resTemp.add(newList);
//        			}      			
//    			}
    			res = resTemp;
    		}
    	}
    	
    	return res;
    }
}
