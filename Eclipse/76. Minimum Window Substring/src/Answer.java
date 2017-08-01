import java.util.HashMap;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();       
        String res = answer.minWindow("AB", "Ab");
        System.out.println(res);
	}
	
	//two pointer substring template
	//https://discuss.leetcode.com/topic/71662/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
    public String minWindow(String s, String t) {
    	if(t.length()> s.length()) return "";
    	
        int resStart = 0, resEnd = Integer.MAX_VALUE;
        HashMap<Character, Integer> dic =  new HashMap<>();
        char[] tchar = t.toCharArray();
        for(char c: tchar){
        	if(!dic.containsKey(c))
        		dic.put(c, 1);
        	else{
        		dic.put(c, dic.get(c)+1);
        	}
        }
        
        int start=0, end=0, count=dic.size();
        char[] schar = s.toCharArray();
        while(end<schar.length){
        	char cur = schar[end];
        	
        	if(dic.containsKey(cur)){
        		dic.put(cur, dic.get(cur)-1);   		
        		if(dic.get(cur)==0)
        			count--;
        	}
        	end++;	

    		while(count==0){
    			char scur = schar[start];
    			
            	if(dic.containsKey(scur)){
            		dic.put(scur, dic.get(scur)+1);   		
            		if(dic.get(scur)>0)
            			count++;
            	}
            	
            	if(end-start<resEnd-resStart){
            		resEnd=end;
            		resStart=start;
            	}
            	
            	start++;
    		}
        }
        
        if(resEnd == Integer.MAX_VALUE) return "";
        return s.substring(resStart, resEnd);
    }
}
