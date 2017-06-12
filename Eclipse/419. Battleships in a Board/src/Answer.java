
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        char[][] input = new char[][]{{'.', '.'},{'X', 'X'}};
        int res = answer.countBattleships(input);
        System.out.println(res);       
	}
	
    public int countBattleships(char[][] board) {
    	int m = board.length, n=0;
    	if(m>0)
    		n= board[0].length;
    	
    	int count =0;
    	
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		if(board[i][j]=='X'){
        			if((i-1<0 || (i-1>=0 && board[i-1][j]=='.')) && (j-1<0 || (j-1>=0 && board[i][j-1]=='.'))){
        				count++;
        			}
        		}
        	}
        }
        
        return count;
    }
}
