import java.util.HashMap;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] input = new int[]{2,7,11,15};
        int[] res =answer.twoSum(input, 13);
        System.out.println(res);       
	}
	
	//Can only work for no dup array
    public int[] twoSum(int[] nums, int target) {
    	int[] res = new int[2];
    	HashMap<Integer,Integer> dic = new HashMap<Integer,Integer>();
    	
        for(int i=0; i<nums.length; i++){
        	int temp = target - nums[i];
        	if(dic.containsKey(temp)){
        		res[0]=i;
        		res[1]=dic.get(temp);
        		return res;
        	}
        		
        	dic.put(nums[i], i);
        }
        
        return res;
    }
    
	//Can only work for no dup array
    public int[] twoSum_tworound(int[] nums, int target) {
    	HashMap<Integer,Integer> dic = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
        	dic.put(nums[i], i);

        }
        
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++){
        	int temp = target - nums[i];
        	if(dic.containsKey(temp) && dic.get(temp)!=i){
        		res[0]=i;
        		res[1]=dic.get(temp);
        	}
        }
        
        return res;
    }
}
