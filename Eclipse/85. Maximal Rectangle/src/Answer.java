
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        char[][] input = {"01101".toCharArray(),"11010".toCharArray(),"01110".toCharArray(), "11110".toCharArray(),"11111".toCharArray(),"00000".toCharArray()};
        //char[][] input = {"11".toCharArray()};
        //List<Integer> res = answer.spiralOrder(input);
        //System.out.println(res);
        int res = answer.maximalRectangle(input);
        System.out.print(res);

	}
	
	//stack solution from 84
	//Easier
	//https://discuss.leetcode.com/topic/1634/a-o-n-2-solution-based-on-largest-rectangle-in-histogram
    public int maximalRectangle_st(char[][] matrix) {
        return 0;
    }
	
    
    //My Dp
    public int maximalRectangle_myDP(char[][] matrix) {
    	int m=matrix.length, n=0;
    	if(m>0)
    		n=matrix[0].length;
    	
    	if(m==0 || n==0)
    		return 0;
    	
    	int res=0;
    	//dp[i][j], start from matrix[i][j] the longest 1 it can has all the way to the left
    	int dp[][] = new int[m][n];
    	for(int i=0; i<m; i++){
    		for(int j=0; j<n; j++){
    			if(matrix[i][j]=='1'){
    				dp[i][j]=j-1>=0? dp[i][j-1]+1: 1;
    			}
    			else
    				dp[i][j]=0;
    			
    			int len=Integer.MAX_VALUE;
    			for(int k=i; k>=0; k--){
    				if(dp[k][j]==0)
    					break;
    				len=Math.min(len, dp[k][j]);
    				res = Math.max(res, len*(i-k+1));
    			}
    			
    		}
    	}
    	
    	return res;
    }
    
	//I saw the solution
	//dp
	//Realy hard to understand
	//h[j], the max height at j of each row
	//l[j], the most left boundary of the rectangle which contains the current point (j) with a height of value h[j]
	//r[j], the most right boundary of the rectangle which contains the current point (j) with a height of value h[j]
	//so the area we can get for each index of each row is (r[j]-l[j]+1)*h[j]
    public int maximalRectangle(char[][] matrix) {
    	int m=matrix.length, n=0;
    	if(m>0)
    		n=matrix[0].length;
    	
    	if(m==0 || n==0)
    		return 0;
    	
        int[] h = new int[n];
        int[] l = new int[n];
        int[] r = new int[n];
        for(int i=0; i<n; i++){
        	r[i]=n-1;
        }
        
        int res=0;
        
        for(int i=0; i<m; i++){   	
        	//height
        	for(int j=0; j<n; j++){
        		if(matrix[i][j]=='1')
        			h[j]=h[j]+1;
        		else
        			h[j]=0;
        	}
        	
        	//left boundary
        	int cur_left=0;
        	for(int j=0; j<n; j++){
        		if(matrix[i][j]=='1'){
        			l[j] = Math.max(l[j], cur_left);
        		}	
        		else{
        			cur_left=j+1;
        			//set to initial state (min for max operation)
        			l[j]=0;
        		}		
        	}
        	
        	//right boundary
        	int cur_right=n-1;
        	for(int j=n-1; j>=0; j--){
        		if(matrix[i][j]=='1'){
        			r[j] = Math.min(r[j], cur_right);
        		}	
        		else{
        			cur_right=j-1;
        			//set to initial state (max for min operation)
        			r[j]=n-1;
        		}		
        	}
        	
            // compute the area of rectangle (can do this from either side)
            for(int j=0; j<n; j++)
                res = Math.max(res,(r[j]-l[j]+1)*h[j]);
        }
        
        return res;
    }
}
