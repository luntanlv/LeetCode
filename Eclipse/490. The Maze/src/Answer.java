import java.util.LinkedList;
import java.util.Queue;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int[][] maze = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0,4};
        int[] des = new int[]{4,4};
        boolean res = answer.hasPath(maze, start, des);
        System.out.print(res);
	}
	
	//BFS
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visted = new boolean[maze.length][maze[0].length];
        q.add(start);
        visted[start[0]][start[1]]=true;
        
        while(!q.isEmpty()){
        	int[] cur = q.poll();
        	
        	if(cur[0]==destination[0] && cur[1]==destination[1])
        		return true;
        	
        	int[] dx = new int[]{0,-1,0,1};
        	int[] dy = new int[]{-1,0,1,0};
        	
        	for(int i=0; i<dx.length; i++){
            	int[] newdirec = new int[]{cur[0], cur[1]};
            	while(newdirec[0]+dx[i]>=0 && newdirec[1]+dy[i]>=0 && newdirec[0]+dx[i]<maze.length && newdirec[1]+dy[i]<maze[0].length
            			&& maze[newdirec[0]+dx[i]][newdirec[1]+dy[i]]!=1){
            		newdirec[0]+=dx[i];
            		newdirec[1]+=dy[i];
            	}
            	if(!visted[newdirec[0]][newdirec[1]]){
            		visted[newdirec[0]][newdirec[1]]=true;
            		q.add(newdirec);
            	}
            		
        	}
        	
        }
        return false;
    }

}
