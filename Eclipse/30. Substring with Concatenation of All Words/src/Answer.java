import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;


public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        ArrayList<Integer> res = answer.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"});
        System.out.println(res);
	}
	
    public ArrayList<Integer> findSubstring(String s, String[] words) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if(words.length <=0)
    		return res;
    	
    	int wordLen = words[0].length();
    	ArrayList<String> wordsSet = new ArrayList<String>();
    	for(int i=0; i<words.length; i++){
    		wordsSet.add(words[i]);
    	}
    	
    	//<starting point, exsitedList>
    	HashMap<Integer, ArrayList<String>> noneExsitedList = new HashMap<Integer, ArrayList<String>>();
    	
    	for(int i=0; i<s.length()-wordLen+1;){
    		String curSub = s.substring(i, i+wordLen); 
    		if(wordsSet.contains(curSub)){
    			
    			//mark current position as a new starting point
    			ArrayList<String> newList = new ArrayList<String>(wordsSet);
    			newList.remove(curSub);
    			noneExsitedList.put(i, newList);
    			
    			HashMap<Integer, ArrayList<String>> updateNoneExsitedList = new HashMap<Integer, ArrayList<String>>();
    			
    			for(Entry<Integer, ArrayList<String>> item : noneExsitedList.entrySet()){

    				ArrayList<String> noneExsited = item.getValue();
    				int curIndex = item.getKey();
    				
    				//the new added starting point
        			if(curIndex == i){
        				updateNoneExsitedList.put(curIndex, noneExsited);
        			}
        			//previous added starting point
        			else if(noneExsited.contains(curSub)){            			
        				noneExsited.remove(curSub);
        				updateNoneExsitedList.put(curIndex, noneExsited);
        			}

        			//
        			if(noneExsited.isEmpty()){
        				res.add(curIndex);
        				updateNoneExsitedList.remove(curIndex);
        			}          			
    			}
    			noneExsitedList=updateNoneExsitedList;
    			i+=wordLen;    
    		}  
    		else{
    			i++;
    			noneExsitedList.clear();
    		}
    	}
    	return res;
    }	
	
}
