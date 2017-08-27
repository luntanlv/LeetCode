
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        //int[][] input = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        //int[][] input = new int[][]{{0,2,3},{2,5,3}};
        //int[][] input = new int[][]{{1,2,1},{1,2,2},{1,2,3}};
        int[][] input = new int[][]{{0,2147483647,2147483647}};
        List<int[]> res =answer.getSkyline_my(input);
        
        for(int[] point: res){
        	for(int x: point)
        		System.out.print(x+", ");
        	System.out.println("");        	
        }

	}
	
	//like 58 https://leetcode.com/problems/merge-intervals/#/description\
	
	//https://briangordon.github.io/2014/08/the-skyline-problem.html
	
	//using array all position
	//buiding like {1, 50000, 10}, {20000, 250000, 20} waste a lot memory and can lead int overflow
    public ArrayList<int[]> getSkyline_eachPointArray(int[][] buildings) {
    	int len =0;
    	for(int[] building : buildings){
    		if(building[1]>len)
    			len = building[1];
    	}
    	
        //height record to height[len], one more space to go back to height 0
    	int[] height = new int[len+2];
    	
    	for(int[] building : buildings){
    		int l = building[0];
    		int r = building[1];
    		int h = building[2];
    		
    		for(int i=l; i<=r; i++){
    			if(height[i]<h)
    				height[i]=h;
    		}	
    	}
    	
    	ArrayList<int[]> resList = new ArrayList<int[]>();
    	int preH=0;
    	for(int i=0; i<height.length; i++){
    		if(height[i] > preH){
    			int[] res = new int[]{i,height[i]};
    			resList.add(res);
    			preH = height[i];
    		}
    		else if(height[i] < preH){
    			int[] res = new int[]{i-1,height[i]};
    			resList.add(res);
    			preH = height[i];
    		}
    	}
    	
    	return resList;
    }
    
    //I saw the solution
    //criticalPointArray
    public ArrayList<int[]> getSkyline(int[][] buildings) {
    	//int[]: 0:x, 1:height, 2:isEnd
    	ArrayList<int[]> criticalPoints = new ArrayList<int[]>();
    	
    	for(int[] building : buildings){
    		int l = building[0];
    		int r = building[1];
    		int h = building[2];
    		
    		criticalPoints.add(new int[]{l,h,0});
    		criticalPoints.add(new int[]{r,h,1});
    	}
    	
    	/**
    	 *  The compare logic is pretty tricky!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    	 */
    	//we compare the x, make sure larger x is at later position
    	//if x are same, we compare isEnd
    	//so at this point there is next start before previous end, so this point won't be a break point(end and start, break after end and then restart again)
    	//so [[0,2,3],[2,5,3]] -> [[0,3],[2,0],[2,3],[5,0]] won't happen
    	//if x and isEnd are both same. we compare isEnd and height combination
    	//when multi start is and same x, we make sure height is decrease( higher height come first), so highest height go into priority queue first, this will avoid lower height go the result
    	//when multi end is and same x, we make sure height is increase( lower height come first), so lowest height remove from priority queue first, this will avoid lower height go the result
    	//so [[1,2,1],[1,2,2],[1,2,3]] -> [[1,1],[1,2],[1,3],[2,0]] won't happen
    	Collections.sort(criticalPoints, (a,b)->{
    		if(a[0]!=b[0])
    			return a[0]-b[0];
    		else if(a[2]!=b[2])
    			return a[2]-b[2];
    		else{
    			//start
    			if(a[2] ==0)
    				return b[1]-a[1];
    			//end
    			else
    				return a[1]-b[1];
    		}
    	});
    	
    	ArrayList<int[]> result = new ArrayList<>();
    	//default: the head of this queue is the least element with respect to the specified ordering, so we reverse the ordering
    	Queue<Integer> priq = new PriorityQueue<>((a, b) -> b - a);
    	
    	//for the last point for height 0
    	priq.add(0);
    	int prevH = 0;
    	for(int[] cp: criticalPoints){
    		if(cp[2]==0)
    			priq.add(cp[1]);
    		else
    			priq.remove(cp[1]);
    		
    		int curH = priq.peek();
    		if(curH != prevH){
    			result.add(new int[]{cp[0], curH});
    			prevH=curH;
    		}
    		
    	}
    	return result;
    }
    
    //Second round my solution
    //will fall on {0,2147483647,2147483647}
    //similar idea to 42. Trapping Rain Water  84. Largest Rectangle in Histogram
    public List<int[]> getSkyline_my(int[][] buildings) {
    	ArrayList<int[]> res = new ArrayList<int[]>();
    	
    	PriorityQueue<int[]> rightQ = new PriorityQueue<>((a1,a2)->a1[1]-a2[1]);
    	PriorityQueue<int[]> heightQ = new PriorityQueue<>((a1,a2)->a2[2]-a1[2]);
    	
    	//will fall on {0,2147483647,2147483647}
    	int[] zeroH = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
		rightQ.add(zeroH);
		heightQ.add(zeroH);
    	
    	for(int[] building : buildings){
    		
    		while(!rightQ.isEmpty() && rightQ.peek()[1]<building[0]){
    			int[] highestBefereEndB = heightQ.peek();
    			int[] endB = rightQ.poll();
    			heightQ.remove(endB);
    			int[] highestAfterEndB = heightQ.peek();
    			
    			if(highestBefereEndB[2] != highestAfterEndB[2]){
    				int[] resPoint = new int[]{endB[1], highestAfterEndB[2]};
    				if(!res.isEmpty() && res.get(res.size()-1)[0] == resPoint[0])
    					res.remove(res.size()-1);
    				res.add(resPoint);
    			}
    		}

    		int[] preHB = heightQ.peek();
    		
			rightQ.add(building);
			heightQ.add(building);
			
			if(preHB[2]<heightQ.peek()[2]){
				int[] resPoint = new int[]{heightQ.peek()[0], heightQ.peek()[2]};
				if(!res.isEmpty() && res.get(res.size()-1)[0] == resPoint[0])
					res.remove(res.size()-1);
				res.add(resPoint);
			}

    	}
    	
		while(rightQ.size()>1){
			int[] highestBefereEndB = heightQ.peek();
			int[] endB = rightQ.poll();
			heightQ.remove(endB);
			int[] highestAfterEndB = heightQ.peek();
			
			if(highestBefereEndB[2] != highestAfterEndB[2]){
				int[] resPoint = new int[]{endB[1], highestAfterEndB[2]};
				if(!res.isEmpty() && res.get(res.size()-1)[0] == resPoint[0])
					res.remove(res.size()-1);
				res.add(resPoint);
			}
		}
		
		return res;
    }
    
}
