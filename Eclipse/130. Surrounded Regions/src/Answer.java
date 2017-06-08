import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        char[][] input = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        answer.solve(input);
        System.out.println(input);       
	}
	
	//BFS
    public void solve(char[][] board) {
    	int m=board.length, n=0;
    	if(m>0)
    		n=board[0].length;
    	else
    		return;
    	
    	int[] dx = new int[]{-1,0,1,0};
    	int[] dy = new int[]{0,-1,0,1};
    	
        boolean[][] visitedO = new boolean[m][n];
        
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		if(board[i][j]=='X' || visitedO[i][j])
        			continue;
        		
                List<Integer> qx = new ArrayList<Integer>();
                List<Integer> qy = new ArrayList<Integer>();
        		qx.add(i);
        		qy.add(j);
        		
        		boolean isSurrounded = true;
        		
        		//Start BFS
        		int bsfIndexStart = 0, bsfIndexEnd=qx.size();
        		while(bsfIndexStart<bsfIndexEnd){       			
            		for(int levelIndex =bsfIndexStart; levelIndex<bsfIndexEnd; levelIndex++){
            			int xo = qx.get(levelIndex);
            			int yo = qy.get(levelIndex);
            			
            			for(int k=0; k<4; k++){
            				int nextx = xo+dx[k], nexty = yo+dy[k];
            				if(nextx<0 || nextx>=m || nexty<0 || nexty>=n){
            					isSurrounded = false;            					
            				}
            				else if(board[nextx][nexty]=='O' && !visitedO[nextx][nexty]){
            					qx.add(nextx);
            					qy.add(nexty);
            					visitedO[nextx][nexty]=true;
            				}
            			}
            		}
        			bsfIndexStart = bsfIndexEnd;
        			bsfIndexEnd = qx.size();
        		}
        		
        		if(isSurrounded){
        			for(int k=0; k<qx.size(); k++){
            			int xflip = qx.get(k);
            			int yflip = qy.get(k);
            			board[xflip][yflip] ='X';
        			}
        		}

        	}
        }
    }
    
    // Second Approch
	//    First, check the four border of the matrix. If there is a element is
	//    'O', alter it and all its neighbor 'O' elements to '1'.
	//    Then ,alter all the 'O' to 'X'
	//    At last,alter all the '1' to 'O'
    //    https://discuss.leetcode.com/topic/17224/a-really-simple-and-readable-c-solution-only-cost-12ms
    
    //Third Approch : Union Find data structure
    // http://blog.csdn.net/dm_vincent/article/details/7655764
    
}
