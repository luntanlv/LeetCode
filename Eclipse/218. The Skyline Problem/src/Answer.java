import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[][] input = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        ArrayList<int[]> res =answer.getSkyline(input);
        System.out.println(res);       
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
    
    public ArrayList<int[]> getSkyline_criticalPointArray(int[][] buildings) {
    	HashMap<Integer, Integer> map = new HashMap<>();
    	
    	for(int[] building : buildings){
    		int l = building[0];
    		int r = building[1];
    		int h = building[2];
    		
    	}

    }
}
