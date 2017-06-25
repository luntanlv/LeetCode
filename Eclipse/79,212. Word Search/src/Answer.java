import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        char[][] input = new char[][]{{'A', 'B', 'C', 'D'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
        //char[][] input = new char[][]{{'A'}};
        boolean res = answer.exist(input, "ABCB");
        
        System.out.println(res);
            
	}
	
//---------------------------- 79 ----------------------------------------------------------------------
    public boolean exist(char[][] board, String word) {
    	if(board.length==0 || board[0].length==0)
    		return word.length()==0? true:false;
    	
    	int m = board.length, n = board[0].length;
    	boolean res = false;
    	
    	for(int i=0; i<m; i++){
    		for(int j=0; j<n; j++){
    			res = helper(board, word, i, j, 0, new boolean[m][n]);
    			if(res)
    				return res;
    		}
    	}
        return res;
    }
    
    boolean helper(char[][] board, String word, int i, int j, int curIndex, boolean[][] visited){
    	if(board[i][j] != word.charAt(curIndex))
    		return false;
    	
    	if(curIndex == word.length()-1)
    		return true;
    	
    	boolean res= false;
    	visited[i][j]=true;
    	if(!res && i-1>=0 && !visited[i-1][j])
    		res= res || helper(board, word, i-1, j, curIndex+1, visited);
    	if(!res && i+1<board.length && !visited[i+1][j])
    		res= res || helper(board, word, i+1, j, curIndex+1, visited);
    	if(!res && j-1>=0 && !visited[i][j-1])
    		res= res || helper(board, word, i, j-1, curIndex+1, visited);
    	if(!res && j+1<board[0].length && !visited[i][j+1])
    		res= res || helper(board, word, i, j+1, curIndex+1, visited);
    	
    	visited[i][j]= false;
    	
    	return res;
    }
    
  //---------------------------- 212 ----------------------------------------------------------------------
  //Using Trie 208
  //Straight forward: https://discuss.leetcode.com/topic/14256/my-simple-and-clean-java-code-using-dfs-and-trie
  //Optimize: https://discuss.leetcode.com/topic/33246/java-15ms-easiest-solution-100-00
    
}
