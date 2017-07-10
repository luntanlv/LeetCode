import java.util.HashMap;
import java.util.HashSet;

public class Answer {

	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int res =answer.lengthOfLongestSubstring("abba");
        int res2 =answer.lengthOfLongestSubstringTwoDistinct("eceba");
        System.out.println(res2);       
	}
	
	//3
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l =0, r=0;
        int maxLen =0;
        char[] sChr = s.toCharArray();
        while(r<sChr.length){
        	if(map.containsKey(sChr[r])){
        		// We don't need remove item already in map before map.get(sChr[r])+1
        		//we just need make sure this exist dup is not coming from item before than current i, which should be deleted for the commented code
        		l=Math.max(map.get(sChr[r])+1, l); 
        		
//        		int newl=map.get(sChr[r])+1;
//        		while(l<newl)
//        			map.remove(sChr[l++]);
        	}
        	
        	map.put(sChr[r], r);
        	maxLen = Math.max(r-l+1, maxLen);
        	r++;
        }
        return maxLen;
    }
    
    //159
    public int lengthOfLongestSubstringTwoDistinct(String s) {
    	Character c1=null, c2= null;
    	int index1=-1, index2=-1;

        int l =0, r=0;
        int maxLen =0;
        char[] sChr = s.toCharArray();
        while(r<sChr.length){
        	if(c1==null || c1.equals(sChr[r])){
        		index1=r;
        		c1=sChr[r];
        	}
        		
        	else if(c2==null || c2.equals(sChr[r])){
        		index2=r;
        		c2=sChr[r];
        	}
        	
        	//c1!=null && c2!=null && !c1.equals(sChr[r]) && !c2.equals(sChr[r])
        	else{
        		l=Math.min(index1, index2)+1;
        		if(index1<index2){
            		index1=r;
            		c1=sChr[r];
        		}
        		else{
            		index2=r;
            		c2=sChr[r];
        		}
        	}
        	
        	maxLen = Math.max(r-l+1, maxLen);
        	r++;
        }
        return maxLen;
    }
}
