
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[][] input = new int[][]{{1,2,3,4,5},{1,0,3,4,5},{1,2,3,4,5},{1,2,3,4,0}};
        
        answer.setZeroes(input);
        
        for(int[] row: input){
        	for(int num: row)
        		System.out.print(num + ", ");
        	System.out.println("");
        }
        
	}
	
    public void setZeroes(int[][] matrix) {
        boolean row0=false, col0=false;
        int m = matrix.length, n=0;
        if(m>0)
        	n=matrix[0].length;
        
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		if(matrix[i][j]==0){
        			if(i==0)
        				row0=true;
        			else{
        				matrix[0][j]=0;
        			}
        			if(j==0)
        				col0=true;
        			else{
        				matrix[i][0]=0;
        			}
        		}
        	}
        }
        
        for(int i=1; i<m; i++){
        	for(int j=1; j<n; j++){
        		if(matrix[0][j]==0 || matrix[i][0]==0)
        			matrix[i][j]=0;
        	}
        }
        
        if(row0)
        	for(int j=0; j<n; j++){
        		matrix[0][j]=0;
        	}
        
        if(col0)
        	for(int i=0; i<m; i++){
        		matrix[i][0]=0;
        	}
    }
	
	
	//not right
    public void setZeroes_notright(int[][] matrix) {
    	int m=matrix.length;
    	if(m==0)
    		return;
    	int n=matrix[0].length;
    	
    	helper(0,m-1,0,n-1,matrix);
    }
    
    public void helper(int startX, int endX, int startY, int endY, int[][] matrix){
    	for(int i = startX; i<=endX; i++){
    		boolean isBreak = false;
    		for(int j = startY; j<=endY; j++){
    			if(matrix[i][j]!=0)
    				continue;
    			
    			helper(i+1, endX, startY, j-1, matrix);
    			helper(i+1, endX, j+1, endY, matrix);
    			
    			for(int k=startY; k<=endY; k++){
    				if(k>j && matrix[i][k]==0){
    	    			for(int l=startX; l<=endX; l++)
    	    				matrix[l][k]=0; 
    				}
    				matrix[i][k]=0;
    			}
    				
    			for(int k=startX; k<=endX; k++){
    				if(k>i && matrix[k][j]==0){
    	    			for(int l=startY; l<=endY; l++)
    	    				matrix[k][l]=0; 
    				}    				
    				matrix[k][j]=0;    		
    			}
    					
    			
    			isBreak = true;
    			break;
    		}
    		if(isBreak)
    			break;
    	}
    }
}
