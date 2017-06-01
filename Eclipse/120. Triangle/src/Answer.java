import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        List<Integer> level1=new ArrayList<Integer>();
        level1.add(-1);
        List<Integer> level2=new ArrayList<Integer>();
        level2.add(-2);
        level2.add(-3);
        
        input.add(level1);
        input.add(level2);
        
        int res = answer.minimumTotal(input);
        System.out.println(res);       
	}
	
	
	//This is Top down, Bottom up is easier
    public int minimumTotal(List<List<Integer>> triangle) {
    	//the level num, also the number of item in bottom level
    	int levelNum = triangle.size();
        int[] dp = new int[levelNum];
        int minimumTotal = 0;
        
        for(int i=0; i<levelNum; i++){
        	minimumTotal = Integer.MAX_VALUE;
        	List<Integer> level = triangle.get(i);
        	for(int j=level.size()-1; j>=0; j--){
        		int left=0, right =0;
        		if(j-1<0){
        			left=dp[j];
        			right=dp[j];
        		}
    			else if(j>i-1){
    				left=dp[j-1];
    				right=dp[j-1];
    			}
    			else{
    				left = dp[j-1];
    				right = dp[j];
    			}
    			
        		dp[j]=Math.min(left, right)+level.get(j);
        		minimumTotal = dp[j]<minimumTotal? dp[j]: minimumTotal;
        	}
        }
        
        return minimumTotal;
        
    }
    
    
}
