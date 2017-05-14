import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
//        List<List<Integer>> res = answer.permute(new int[]{1,2,3});
//        for(List<Integer> oneList : res){
//        	System.out.println(oneList);
//        }
        
        String res  = answer.getPermutation(4, 14);
        System.out.println(res);
	}
	
	//get all permutation
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
    
    //get kth permutation
    public String getPermutation(int n, int k) {
    	StringBuilder resBuilder = new StringBuilder();   	
    	List<Integer> availableNum = new ArrayList<Integer>();
    	
    	for(int i=1; i<=n;i++)
    		availableNum.add(i);
    	
        for(int i=1; i<=n; i++){
        	int eachPnum =getFactorial(n-i);
        	
        	int temp = k/eachPnum;
        	if(k-temp*eachPnum==0){
        		temp--;
        	}	
        	//Another approch to solve conner case
//        	int temp = (k-1)/eachPnum;
        	
        	k=k-temp*eachPnum;
        	
        	int curRes = availableNum.get(temp);
        	availableNum.remove(temp);
        	resBuilder.append(String.valueOf(curRes));
        }
        
        return resBuilder.toString();
    }
    
    //can use cache to store previous res for factorial
    public int getFactorial(int n){
    	int res=1;
    	for(int i=0; i<n;i++)
    		res*=n-i;
    	return res;
    }
    
}
