import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{33,90,57,39,42,45,29,90,81,87,88,37,58,97,80,2,77,64,82,41,2,33,34,95,85,77,92,3,8,15,71,84,58,65,46,48,3,74,4,83,23,12,15,77,33,65,17,86,21,62,71,55,80,63,75,55,11,34,-1,64,81,18,77,82,8,12,14,6,46,39,71,14,6,46,89,37,88,70,88,33,89,92,60,0,78,10,88,99,20};
        List<Integer> res = answer.cheapestJump(input,74);
        System.out.print(res);
	}
	
    public List<Integer> cheapestJump(int[] A, int B) {
    	List<Integer> res = new ArrayList<>();
    	if(A.length<=0 || B<=0)
    		return res;
    	
    	//min cost to get i from 0;
    	int[] dp = new int[A.length];
    	//previous step index to get i with min cost 
    	int[] preIndexDp = new int[A.length];
    	
    	dp[0]=A[0];
    	preIndexDp[0]=0;
    	
    	for(int i=1; i<A.length; i++){
    		if(A[i]<0){
    			//indicate that cannot reached
    			preIndexDp[i]=-1;
    			continue;
    		}
    			
    		
    		int minPreCost =Integer.MAX_VALUE, minPreIndex=-1;
    		for(int j=B; j>=1; j--){
    			int preIndex = i-j;
    			if(preIndex<0 || preIndexDp[preIndex]<0)
    				continue;
    				
				if(minPreCost>dp[preIndex]){
					minPreCost = dp[preIndex];
					minPreIndex = preIndex;
				}    			
    		}
    		
    		dp[i]=minPreCost + A[i];
    		preIndexDp[i]= minPreIndex;
    	}
    	
    	
    	if(preIndexDp[preIndexDp.length-1]>=0){
    		res.add(preIndexDp.length); 		
        	for(int i=preIndexDp.length-1; i>0;){
        		res.add(0,preIndexDp[i]+1);
        		i=preIndexDp[i];
        	}
    	}
    	   	
    	return res;
    }
}
