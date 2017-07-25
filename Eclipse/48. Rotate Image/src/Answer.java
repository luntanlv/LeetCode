public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[][] input = {{1,0,0,1},{1,2,3,4},{1,2,4,3},{1,3,2,4}};
        answer.rotate_better(input);
        for(int i = 0; i<input.length; i++){
        	for(int j=0; j<input[0].length; j++){
        		System.out.print(input[i][j] + ", ");
        	}
        	System.out.println();
        	
        }
	}
	
	//two flip. 1 diagonal, 2. left right
	//I saw the solution
    public void rotate_better(int[][] matrix) {
    	int n=matrix.length;    	
        for(int i=0; i<n; i++){
        	for(int j=0; j<i; j++){
        		int temp = matrix[i][j];
        		matrix[i][j]=matrix[j][i];
        		matrix[j][i] = temp;
        	}
        }
        
        for(int i=0; i<n; i++){
        	for(int j=0; j<n/2; j++){
        		int temp=matrix[i][j];
        		matrix[i][j]=matrix[i][n-1-j];
        		matrix[i][n-1-j] = temp;
        	}
        }
    }

	
	//swtich value from most out layer in the matrix to inner layer, 
	//in each layer switch value by rotating clockwise 4 times, make value[j][n-i]=value[i][j] each time.
    public void rotate(int[][] matrix) {
        int n=matrix.length-1;
        
        for(int i=0;i<=n/2;i++)
        {      	
        	for(int j=i; j<n-i;j++)
        	{
        		int value=matrix[i][j];
        		int tempI =i, tempJ=j;
        		
        		for(int k=0; k<4; k++)
        		{   			
        			int newTempI=tempJ;
        			int newTempJ=n-tempI;
        			int tempValue = matrix[newTempI][newTempJ];
        			matrix[newTempI][newTempJ] = value;
        			value = tempValue;
        					
        			tempI = newTempI;
        			tempJ = newTempJ;    			     			
        		}
        		
        	}
        }
    }
}
