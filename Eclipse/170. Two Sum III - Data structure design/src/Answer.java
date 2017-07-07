import java.util.HashMap;
import java.util.Map;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        TwoSum ts = answer.new TwoSum();
        ts.add(1);
        ts.add(1);
        ts.add(-1);
        ts.add(-1);
        boolean res = ts.find(-2);
        System.out.println(res);       
	}
	
	/**
	 * Trade off in this problem should be considered
	 * 
	 * The big data test only have the condition that lots of add and few find. 
	 * In fact, there has to be one operation's time complexity is O(n) and the other is O(1), no matter add or find. 
	 * So clearly there's trade off when solve this problem, prefer quick find or quick add.
	 *
	 * https://discuss.leetcode.com/topic/32449/trade-off-in-this-problem-should-be-considered
	 */
	
	public class TwoSum {

		//key: num, val: count;
		private HashMap<Integer, Integer> dic;
		
	    /** Initialize your data structure here. */
	    public TwoSum() {
	        dic = new HashMap<Integer, Integer>();
	    }
	    
	    /** Add the number to an internal data structure.. */
	    public void add(int number) {
	        if(!dic.containsKey(number)){
	        	dic.put(number, 1);
	        }
	        else{
	        	dic.put(number, dic.get(number)+1);
	        }
	    }
	    
	    /** Find if there exists any pair of numbers which sum is equal to the value. */
	    public boolean find(int value) {
	    	for(Map.Entry<Integer, Integer> dicItem : dic.entrySet()){
	    		int curKey = dicItem.getKey();
	    		int curCount = dicItem.getValue();
	    		int target = value - curKey;
	    		dic.put(curKey, curCount-1);
	    		
	    		if(dic.containsKey(target) && dic.get(target)>0){
	    			dic.put(curKey, curCount);
	    			return true;
	    		}
	    			
	    		dic.put(curKey, curCount);
	    		
	    	}
	    	return false;
	    }
	}

	/**
	 * Your TwoSum object will be instantiated and called as such:
	 * TwoSum obj = new TwoSum();
	 * obj.add(number);
	 * boolean param_2 = obj.find(value);
	 */
}
