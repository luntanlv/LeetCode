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
	 *	��ʼ����Դ�field���ĸ���ѡȡ������Ҫѡȡ��ͬ��ʼ���²�����С�ķ���
	 * �ڶ���,golf event Ҫ����������ÿ��ֻ�ܿ���������������ǿš���ʵ���� maze ��ı��Ρ�2D-array. 0 ������,
		1 ������,>1 ������,Ҫ���������Ǵ�ԭ�㿪ʼ,�ߵ�ÿ�ŵ�ǰ����������ǿ�����Ĳ���+��Ҫ�������ĸ߶�
		���ܺ͡������Ҿ������Һ����е���,�ź���,Ȼ���һ���㵽��һ������ BFS�� �ҳ���С������
		�ٸ����� [[1,1,0,2],[3,1,1,1]], ��(0,0)�ߵ� (0,3)--��2 �����,���� 5 ��+2(����),Ȼ���(0,3)
		�ߵ� (1,0)->3 ����� 4 ��+3(����)���� 5+2+4+3 ���� 14
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
