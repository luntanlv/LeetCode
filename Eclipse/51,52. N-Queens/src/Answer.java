import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        List<List<String>> res = answer.solveNQueens(4);
        System.out.println(res);    
	}
	
	//51
	//I saw the solution
    public List<List<String>> solveNQueens(int n) {
    	char[][] curb = new char[n][n];
    	for(int i=0; i<n; i++){
    		for(int j=0; j<n; j++){
    			curb[i][j]='.';
    		}
    	}
    	
    	List<List<String>> res = new ArrayList<>();
    	backtracking(res, curb, 0, n);
    	
    	return res;
    }
    
    private void backtracking(List<List<String>> res, char[][] curb, int row, int n){
    	if(row==n){
    		List<String> newRes = new ArrayList<String>();
    		for(int i=0; i<n; i++){
    			StringBuilder sb = new StringBuilder();
    			for(int j=0; j<n; j++){
    				sb.append(curb[i][j]);
    			}
    			newRes.add(sb.toString());
    		}
    		res.add(newRes);
    	}
    	
    	for(int col=0; col<n; col++){
    		if(validation(curb, row, col)){
    			curb[row][col]='Q';
    			backtracking(res, curb, row+1, n);
    			curb[row][col]='.';
    		}
    	}
    }
    
    private boolean validation(char[][] curb, int row, int col){
    	//same col
    	for(int i=row-1; i>=0; i--){
    		if(curb[i][col]=='Q')
    			return false;
    	}
    	
    	//diagonal
    	for(int i=row-1, j= col-1; i>=0 && j>=0; i--, j--){
    		if(curb[i][j]=='Q')
    			return false;
    	}
    	
    	for(int i=row-1, j= col+1; i>=0 && j<curb.length; i--, j++){
    		if(curb[i][j]=='Q')
    			return false;
    	}
    	return true;
    }
    
    //52
    //I saw the solution
    //https://discuss.leetcode.com/topic/5962/accepted-java-solution
    public int totalNQueens(int n) {
        
    }
}
