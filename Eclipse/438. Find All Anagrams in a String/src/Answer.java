import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Answer {

	public static void main(String [] args)
	{
        Answer answer = new Answer();       
        List<Integer> res = answer.findAnagrams("abaacbabc", "abc");
        System.out.println(res);
	}
	
	//Substring template
	//https://discuss.leetcode.com/topic/71662/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
    public List<Integer> findAnagrams(String s, String p) {
    	List<Integer> res = new ArrayList<>();
        if(s.length()==0)
        	return res;
        
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        HashMap<Character, Integer> dic = new HashMap<>();
        for(char c: pc){
        	if(!dic.containsKey(c))
        		dic.put(c, 1);
        	else
        		dic.put(c, dic.get(c)+1);
        }
        
        int start=0, end=0, count=p.length();
        HashMap<Character, Integer> curDic = new HashMap<>(dic);
        while(end<sc.length){
        	char cur = sc[end];
        	if(curDic.containsKey(cur)){
        		if(curDic.get(cur)>0){
        			curDic.put(cur, curDic.get(cur)-1);
        			count--;
        			
        			if(count==0){
        				res.add(start);
        				curDic.put(sc[start], curDic.get(sc[start])+1);
        				start++;
        				count++;
        			}
        		}
        		else{
        			char curS = sc[start];
        			while(curS != cur){
        				curDic.put(curS, curDic.get(curS)+1);
        				start++;
        				count++;
        				curS = sc[start];
        			}
        			start++;
        		}
        		end++;
        	}
        	else{
        		curDic = new HashMap<>(dic);
        		end++;
        		start=end;
        		count=pc.length;
        	}
        }
        
        return res;
    }
}
