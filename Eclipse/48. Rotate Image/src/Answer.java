public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[][] input = {{1,0,0,1},{1,2,3,4},{1,2,4,3},{1,3,2,4}};
        answer.rotate(input);
        for(int i = 0; i<input.length; i++){
        	for(int j=0; j<input[0].length; j++){
        		System.out.print(input[i][j] + ", ");
        	}
        	System.out.println();
        	
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
