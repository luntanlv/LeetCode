import java.util.Stack;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int[] ratings = new int[]{1,2,5};
        int res = answer.candy_st(ratings);
        System.out.println(res);       
	}
	
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0]=1;
        
    	for(int i=1; i<ratings.length; i++){
    		candy[i] = ratings[i]>ratings[i-1]? candy[i-1]+1 : 1;
    	}
    	
    	for(int i=ratings.length-2; i>=0; i--){
    		candy[i] = ratings[i]>ratings[i+1] ? Math.max(candy[i+1]+1, candy[i]) : candy[i];
    	}	
    	
    	int res =0;
    	for(int count: candy)
    		res+=count;
    	return res;
    }
    
    //I saw the solution,
    //O(1) space, the idea of using stack
    public int count(int n) {
        return (n * (n + 1)) / 2;
    }
    public int candy_o1(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int old_slope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int new_slope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
            if ((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (new_slope > 0)
                up++;
            if (new_slope < 0)
                down++;
            if (new_slope == 0)
                candies++;

            old_slope = new_slope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }
}
