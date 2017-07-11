
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[][] nums = new int[][]{{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
        int res = answer.minCost(nums);
        
        System.out.println(res);    
	}
	
	//Special DP, multiple state transaction equation
	//Instead of having something like f(n)=f(n-x)+f(n-y), which has only one state equation
	//It has two state equation, f1(n) and f2(n).
	//We divide the number of ways you can paint the fence to two cases: \
	//	1. f1(n): number of ways you can paint the fence with last two having same color at fence n
	//	2. f2(n): number of ways you can paint the fence with last two having different color at fence n
	//For this question, f1(n) and f2(n), we only care about last time state, so both of them can be just a variable: same and dif
    public int numWays(int n, int k) {
    	if(n==0)
    		return 0;
    	else if(n==1)
    		return k;
        int same=k, dif =k*(k-1);
        
        for(int i=2; i<n; i++){
        	int newSame = dif * 1;
        	int newDif = same*(k-1) + dif*(k-1);
        	
        	same = newSame;
        	dif = newDif;
        }
        
        return same+dif;
    }
}
