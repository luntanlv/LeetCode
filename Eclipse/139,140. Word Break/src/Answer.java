import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        String[] input = new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        boolean res = answer.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList(input));
        System.out.println(res);       
	}
	
	//139
	// top down
    public boolean wordBreak_topDown(String s, List<String> wordDict) {
    	return wordBreak_helper(s, wordDict, 0, new int[s.length()]);
    }
	
    //dp[i] indicate whether s.substring(i, s.length) can be break
    public boolean wordBreak_helper(String s, List<String> wordDict, int index, int[] dp) 
    {
    	if(index == s.length() )
    		return true;
        
    	for(int i=index+1; i<=s.length(); i++)
    	{
    		String sub = s.substring(index, i);
    		if(wordDict.contains(sub))
    		{
    			boolean res;
    			if(dp[i-1]==0){
    				res = wordBreak_helper(s, wordDict, i, dp);
    				dp[i-1]=res? 1:-1;
    			}  				
    			else
    				res = dp[i-1]>0? true: false;
    				
    			if(res)
    				return true;
    		}
    	}
    	
    	return false;
    }
    
    //139
    //bottom up
    //I saw the solution
    public boolean wordBreak_bottomUp(String s, List<String> wordDict) {
    	//dp[i] is set to true if a valid word (word sequence) ends there. 
    	boolean[] dp = new boolean[s.length()];
    	
    	for(int i=0; i<s.length(); i++){		
    		for(int j=0; j<=i; j++){
    			String j2i = s.substring(j,i+1);
    			if(wordDict.contains(j2i) && (j-1<0 || dp[j-1])){
    				dp[i]=true;
    			}			
    		}
    	}
    	
    	return dp[dp.length-1];
    }
    
    //------------------------------------------------------------------------------------------------//
    //140
    //regular back tracking, Time Limit Exceeded, O(n^n) time, since each i(0~n) has n loop
    public List<String> wordBreak(String s, List<String> wordDict) {
    	List<String> res = new ArrayList<String>();
    	wordBreak_BackTracking(s, wordDict, res, new StringBuilder());
    	return res;
    }
    
    private void wordBreak_BackTracking(String s, List<String> wordDict, List<String> res, StringBuilder cur) {
    	//Found one path while DFS, construct the path on the way of recursion instead of on the way of back tracking
        if(s.length()==0){
        	res.add(cur.toString());
        	return;
        }
        
        for(int i =1; i<=s.length(); i++){
        	String sub = s.substring(0, i);
        	if(wordDict.contains(sub)){
        		String realSub = cur.length() == 0? sub : " "+ sub;
        		cur.append(realSub);
        		wordBreak_BackTracking(s.substring(i,s.length()), wordDict, res, cur);
        		cur.delete(cur.length()-realSub.length(), cur.length());
        	}
        }
        
        return;    	
    }
    
    
    
    //dp, top down recursion BackTracking
    public List<String> wordBreak_topDownDp(String s, List<String> wordDict) {
    	
    	List<String>[] dp = new List[s.length()];
    	List<String> res = wordBreak_BackTracking_topDownDp(s, wordDict, 0, dp);
    	return res;
    }
    
    //dp[i] store res for s.substring(i, s.length)
    private List<String> wordBreak_BackTracking_topDownDp(String s, List<String> wordDict, int index, List<String>[] dp) {
    	List<String> levelRes = new ArrayList<String>();
    	
    	//Found one path while DFS, construct the path on the way of back tracking
        if(index == s.length()){
        	levelRes.add("");
        	return levelRes;
        }
        
        for(int i = index; i<=s.length(); i++){
        	String sub = s.substring(index, i);
        	
        	if(wordDict.contains(sub)){
        		List<String> nextLevelRes = null;
        		if(dp[i-1] == null){       		
            		nextLevelRes = wordBreak_BackTracking_topDownDp(s, wordDict, i, dp);	
        		}
        		else{
        			nextLevelRes = dp[i-1];
        		}
        		
        		//if nextLevel is empty not null, mean there is not path from i to end, so nothing will add to current level
        		for(String nextLevel: nextLevelRes){
        			levelRes.add(sub + (nextLevel.length()==0? "": " ") + nextLevel);
        		}
        	}
        }
        
        if(index-1>=0)
        	dp[index-1]= levelRes;   
        
        return levelRes;    	
    }
    
    
    //dp bottom up
    public List<String> wordBreak_bottomUp_140(String s, List<String> wordDict) {
    	//dp[i] stores break list till i
    	List<String>[] dp = new List[s.length()];
    	
    	for(int i=0; i<s.length(); i++){
    		List<String> levelRes = new ArrayList<String>();
    		
    		for(String word: wordDict){
    			int subStartingIndex = i-word.length()+1;
    			
    			if(subStartingIndex>=0){
    				String sub = s.substring(subStartingIndex, i+1);
    				
    				if(word.equals(sub)){
    					List<String> preResList;
    					if(subStartingIndex-1>=0)
    						preResList =dp[subStartingIndex-1];
    					else{
    						preResList = new ArrayList<String>();
    						preResList.add("");
    					}
    					
    					// if preResList is empty, means preResList cannot break, so res will not add to current level
    					for(String preRes : preResList){
    						levelRes.add(preRes+ (preRes.length()==0?"":" ") + sub);
    					}
    				}
    			}
    		}
    		dp[i]=levelRes;
    	}
    	
    	return dp[s.length()-1];

    }
    
    public List<String> wordBreak_bottomUp_140_editor_solution(String s, List<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }
}
