
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
	
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n=0;
        if(m>0)
        	n=matrix[0].length;
        
        int start=0, end= m*n-1;
        while(start<=end){
        	int mid = start+ (end-start)/2;
        	int x = mid/n;
        	int y = mid%n;
        	
        	if(matrix[x][y]<target)
        		start = mid+1;
        	else if(matrix[x][y]>target)
        		end = mid -1;
        	else
        		return true;       	
        }
        
        return false;
    }
}
