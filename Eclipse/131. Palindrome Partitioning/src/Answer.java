import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();   
        List<List<String>> res = answer.partition("aabb");
        System.out.println(res);       
	}
	
	
	//Back tracking 
    public List<List<String>> partition(String s) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	backTracking(s, res, new ArrayList<String>());
    	return res;
    }
    
    private void backTracking(String s, List<List<String>> res, List<String> cur){
    	if(s.length()==0){
    		List<String> newRes = new ArrayList<String>(cur);
    		res.add(newRes);
    		return;
    	}
    	
    	for(int i =1; i<=s.length(); i++){
    		String l = s.substring(0, i);
    		String r = s.substring(i,s.length());
    		if(isPalindrome(l)){
    			cur.add(l);
    			backTracking(r, res, cur);
    			cur.remove(cur.size()-1);
    		}
    	}
    }
    
    //DP
    // https://discuss.leetcode.com/topic/2884/my-java-dp-only-solution-without-recursion-o-n-2
    // https://discuss.leetcode.com/topic/37756/java-dp-dfs-solution/2
    public List<List<String>> partition_dp(String s) {
    	List<List<String>> res = new ArrayList<List<String>>();

    }    
    
    private boolean isPalindrome(String s){
    	int l =0, r =s.length()-1;
    	while(l<r){
    		if(s.charAt(l) != s.charAt(r))
    			return false;
    		l++;
    		r--;
    	}
    	return true;
    }
}
