import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        String res = answer.getPermutation(3,6);
        System.out.println(res);
	}
	
	
	//one key point is use an array to track whhich num is used and which ones are left
    public String getPermutation(int n, int k) {
        k=k-1;
    	StringBuilder resBuilder = new StringBuilder();   	
    	List<Integer> availableNum = new ArrayList<Integer>();
    	
    	for(int i=1; i<=n;i++)
    		availableNum.add(i);
    	
        for(int i=1; i<=n; i++){
        	int eachPnum =getFactorial(n-i);
        	
        	int temp = k/eachPnum;

            k = k%eachPnum;
        	
        	int curRes = availableNum.get(temp);
        	availableNum.remove(temp);
        	resBuilder.append(String.valueOf(curRes));
        }
        
        return resBuilder.toString();
    }
    
    public int getFactorial(int n){
    	int res=1;
    	for(int i=0; i<n;i++)
    		res*=n-i;
    	return res;
    }
}
