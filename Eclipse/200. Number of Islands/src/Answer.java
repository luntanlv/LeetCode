import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        char[][] input = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','1','0','0'}};
        char[][] input2 = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        int res =answer.numIslands(input);
        System.out.println(res);       
	}
	
	//DFS also works
	// https://discuss.leetcode.com/topic/13248/very-concise-java-ac-solution
	
	//First solution BFS like 130
    public int numIslands_bfs(char[][] grid) {
    	int m=grid.length, n=0;
    	if(m>0)
    		n=grid[0].length;
    	else
    		return 0;
    	
    	int[] dx = new int[]{-1,0,1,0};
    	int[] dy = new int[]{0,-1,0,1};
    	
        boolean[][] visitedO = new boolean[m][n];
        int islandCount =0;
        
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		if(grid[i][j]=='0' || visitedO[i][j])
        			continue;
        		
                List<Integer> qx = new ArrayList<Integer>();
                List<Integer> qy = new ArrayList<Integer>();
        		qx.add(i);
        		qy.add(j);
        		
        		
        		//Start BFS
        		int bsfIndexStart = 0, bsfIndexEnd=qx.size();
        		while(bsfIndexStart<bsfIndexEnd){       			
            		for(int levelIndex =bsfIndexStart; levelIndex<bsfIndexEnd; levelIndex++){
            			int xo = qx.get(levelIndex);
            			int yo = qy.get(levelIndex);
            			
            			for(int k=0; k<4; k++){
            				int nextx = xo+dx[k], nexty = yo+dy[k];
            				if(nextx<0 || nextx>=m || nexty<0 || nexty>=n){
            					continue;
            				}
            				else if(grid[nextx][nexty]=='1' && !visitedO[nextx][nexty]){
            					qx.add(nextx);
            					qy.add(nexty);
            					visitedO[nextx][nexty]=true;
            				}
            			}
            		}
        			bsfIndexStart = bsfIndexEnd;
        			bsfIndexEnd = qx.size();
        		}
        		islandCount++;

        	}
        }
        return islandCount;
    }
    
	//Second solution Union Find
    //http://blog.csdn.net/dm_vincent/article/details/7655764
    public int numIslands(char[][] grid) {
    	int m=grid.length, n=0;
    	if(m>0)
    		n=grid[0].length;
    	else
    		return 0;
    	
    	//Initialize: treat all '1' position as a stand alone group, get total group num
    	int[] group = new int[n*m];
    	int groupSize = 0;        
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		int groupNumCur = i*n+j;
        		group[groupNumCur] = groupNumCur;
        		if(grid[i][j]=='1'){       			            		
            		groupSize++;
        		}
        	}
        }
       
    	int[] dx = new int[]{-1,0,1,0};
    	int[] dy = new int[]{0,-1,0,1};
        
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		if(grid[i][j]=='0')
        			continue;
        		
        		int groupNumCur = i*n+j;

        		for(int k=0; k<4; k++){
        			int sur_x = i+dx[k];
        			int sur_y = j+dy[k];
        			
        			if(sur_x>=0 && sur_x<m && sur_y>=0 && sur_y<n && grid[sur_x][sur_y]=='1'){
            			int groupNumSur = (i+dx[k])*n+j+dy[k];
            			
            			while(group[groupNumSur]!=groupNumSur){
            				//Set groupNumSur's father link to groupNumSur's grandfather, short the link to find group num
            				group[groupNumSur] = group[group[groupNumSur]];
            				groupNumSur = group[groupNumSur];
            			}	
            			
            			while(group[groupNumCur]!=groupNumCur){
            				group[groupNumCur] = group[group[groupNumCur]];
            				groupNumCur = group[groupNumCur];
            			}
            				    			
            			if(groupNumCur != groupNumSur){
            				group[groupNumCur] = groupNumSur;
            				groupSize--;
            			}        				
        			}

        		}      		
        	}
        }
        
        return groupSize;
        
    }
}
