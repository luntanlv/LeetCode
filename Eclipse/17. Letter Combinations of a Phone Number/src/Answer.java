import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        List<String> res = answer.letterCombinations("23");
        System.out.println(res);       
	}
	
    public List<String> letterCombinations(String digits) {
    	HashMap<Character, List<String>> map =  new HashMap<Character, List<String>>();
    	map.put('2', Arrays.asList(new String[]{"a", "b", "c"}));
    	map.put('3', Arrays.asList(new String[]{"d", "e", "f"}));
    	map.put('4', Arrays.asList(new String[]{"g", "h", "i"}));
    	map.put('5', Arrays.asList(new String[]{"j", "k", "l"}));
    	map.put('6', Arrays.asList(new String[]{"m", "n", "o"}));
    	map.put('7', Arrays.asList(new String[]{"p", "q", "r", "s"}));
    	map.put('8', Arrays.asList(new String[]{"t", "u", "v"}));
    	map.put('9', Arrays.asList(new String[]{"w", "x", "y", "z"}));
    	
    	List<String> res = new ArrayList<String>();
    	backtracking(map, res, new StringBuilder(), digits, 0);
    	return res;
    }
    
    private void backtracking(HashMap<Character, List<String>> map, List<String> res, StringBuilder cur, String digits, int index){
    	if(index == digits.length()){
    		if(cur.length()>0)
    			res.add(cur.toString());
    		return;
    	}
    
    	char c = digits.charAt(index);
    	List<String> letterList = map.get(c);
    	
    	for(int i=0; i<letterList.size(); i++){
    		cur.append(letterList.get(i));
    		backtracking(map, res, cur, digits, index+1);
    		cur.deleteCharAt(cur.length()-1);
    	}
    		
    	return;
    }
}
