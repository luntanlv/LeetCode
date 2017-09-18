import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int[][] fields = new int[][]{{1,1,0,2},{3,1,1,1}};
        int res = answer.flatFields(fields);
        System.out.print(res);
	}
	
	//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=289918&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
	//http://www.1point3acres.com/bbs/thread-288537-1-1.html
	/*
	 *	起始点可以从field的四个角选取，所以要选取不同起始点下步数最小的返回
	 * 第二题,golf event 要砍树。。。每次只能砍所有树里面最矮的那颗。其实就是 maze 题的变形。2D-array. 0 不能走,
		1 可以走,>1 就是树,要求的输出就是从原点开始,走到每颗当前树里面最矮的那颗所需的步数+需要砍得树的高度
		的总和。方法我就是先找好所有的树,排好序,然后从一个点到另一个点做 BFS。 找出最小步数。
		举个例子 [[1,1,0,2],[3,1,1,1]], 从(0,0)走到 (0,3)--》2 这棵树,就是 5 步+2(树高),然后从(0,3)
		走到 (1,0)->3 这棵树 4 步+3(树高)所以 5+2+4+3 返回 14
	 */
	public int flatFields (int[][] fields) {
        // corner case
        if (fields == null || fields.length == 0 || fields[0].length == 0) return 0;

        int row = fields.length;
        int col = fields[0].length;	
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->fields[a[0]][a[1]]-fields[b[0]][b[1]]);
        //We assume no tree with same height
        //key: hight, value: positions of tree
        //HashMap<Integer, List<int[]>> treeGoup = new HashMap<>();
        for(int i=0; i<row; i++){
        	for(int j=0; j<col; j++){
        		int h = fields[i][j];
        		if(h>1){
        			pq.add(new int[]{i,j});
        		}
        	}
        }
        
        int res = 0;
        //Where is the Src???
        //int[] src = new int[]{row-1, col-1};
        int[] src = new int[]{0, 0};
        
        while(!pq.isEmpty()){
        	 int[] tar = pq.poll();
        	 
        	 int curRes = bfs(fields, src, tar);
        	 if(curRes!=-1){
        		 //Add tree height??
        		 res+=curRes+fields[tar[0]][tar[1]];
        		 fields[tar[0]][tar[1]]=1;
        		 src=tar;
        	 }
        	 else{
        		 return -1;
        	 }
        }
        return res;
        
	}
	
	
    public int bfs(int[][] fields, int[] src, int[] tar) {
        int row = fields.length;
        int col = fields[0].length;	
    	
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visted = new boolean[row][col];
        
        q.add(src);
        visted[src[0]][src[1]]=true;
        
    	int[] dx = new int[]{0,-1,0,1};
    	int[] dy = new int[]{-1,0,1,0};
    	int step=0;
        
        while(!q.isEmpty()){
        	int qsize = q.size();
        	
        	for(int li=0; li<qsize;li++){
            	int[] cur = q.poll();
            	
            	if(cur[0]==tar[0] && cur[1]==tar[1])
            		return step;
            	    	
            	for(int i=0; i<dx.length; i++){
                	int newx= cur[0]+dx[i], newy = cur[1]+dy[i];
                	
                	if(newx>=0 && newy>=0 && newx<row && newy<col && !visted[newx][newy]
                			&& (fields[newx][newy]==1 || fields[newx][newy]== fields[tar[0]][tar[1]])){
                		visted[newx][newy]=true;
                		q.add(new int[]{newx, newy});
                	}
                		
            	}
        	}
        	step++;

        }
        return -1;
    }
}
