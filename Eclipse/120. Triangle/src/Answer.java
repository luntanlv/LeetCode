import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        
        //List<List<Integer>> res = answer.generate(6);
        List<Integer> res = answer.getRow(5);
        System.out.println(res);       
	}
	
    public int minimumTotal(List<List<Integer>> triangle) {
    	//the level num, also the number of item in bottom level
    	int levelNum = triangle.size();
        int[] dp = new int[levelNum];
        
        for(int i=0; i<levelNum; i++){
        	List<Integer> level = triangle.get(i);
        	for(int j=0; j<level.size(); j++){
        		int pre =0;
        		if(j-1<0)
        			pre=dp[j];
        		if(j>i-1)
        			pre=dp[j-1];
        		dp[j]=Math.min(dp[j], dp[j-1])+level.get(j);
        	}
        }
        
    }
}
