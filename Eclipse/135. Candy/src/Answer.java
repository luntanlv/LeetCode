
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int[] ratings = new int[]{4,5,3,2};
        int res = answer.candy(ratings);
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
}
