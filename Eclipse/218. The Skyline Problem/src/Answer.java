import java.awt.List;
import java.util.ArrayList;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] input = new int[]{3,0,1};
        int res =answer.missingNumber(input);
        System.out.println(res);       
	}
	
	//like 58 https://leetcode.com/problems/merge-intervals/#/description\
	
	//using array all position
    public List<int[]> getSkyline(int[][] buildings) {
    	int len =0;
    	for(int[] building : buildings){
    		if(building[1]>len)
    			len = building[1];
    	}
    	
        //heigth record to height[len], one more space to go back to height 0
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
    		if(height[i] != preH){
    			int[] res = new int[]{i,height[i]};
    			resList.add(res);
    			preH = height[i];
    		}
    	}
    	
    	return resList;
    }
}
