import java.util.Arrays;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        //int[][] input = new int[][]{{1,2},{3,4},{5,6},{7,8}};
        int[][] input = new int[][]{{10,16}, {2,8}, {1,6}, {7,12}};
        int res =answer.findMinArrowShots(input);
        System.out.println(res);       
	}

	//I saw the solution
	
	/*
	 * Idea:
	 * We know that eventually we have to shoot down every balloon, 
	 * so for each balloon there must be an arrow whose position is between balloon[0] and balloon[1]. 
	 * Given that, we can sort the array of balloons by their ending position. 
	 * Then we make sure that while we take care of each balloon from the beginning, we can shoot as many following balloons as possible.
	 * 
	 * So what position should we pick? 
	 * We should shoot as right as possible, because all balloons' end position is to the right of the current one. 
	 * Therefore the position should be currentBalloon[1], because we still need to shoot down the current one.
	 * 
	 */
    public int findMinArrowShots(int[][] points) {
    	if(points.length ==0)
    		return 0;
    	
        Arrays.sort(points, (a, b)-> a[1]-b[1]);
        int balloonIndexOfUnBursted = 0;
        int count=0;
        
        for(int i=1; i<points.length; i++){
        	int[] curB = points[i];
        	int samllestEndOfUnBursted = points[balloonIndexOfUnBursted][1];
        	
        	if(curB[0] > samllestEndOfUnBursted){
        		count++;        		
        		balloonIndexOfUnBursted = i;
        	}
        }
        
        if(balloonIndexOfUnBursted<=points.length-1)
        	count++;
        return count;
    }
}
