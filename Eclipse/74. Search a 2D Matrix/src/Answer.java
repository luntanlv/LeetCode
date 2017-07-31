
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
        
    }
}
