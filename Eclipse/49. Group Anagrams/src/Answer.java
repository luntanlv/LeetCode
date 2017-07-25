
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = answer.groupAnagrams(input);
        System.out.println(res);    
	}
	
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> dic = new HashMap<>();
        List<List<String>> res= new ArrayList<>();
        
        for(String s: strs){
        	char[] srt = s.toCharArray();
        	Arrays.sort(srt);
        	String key = String.valueOf(srt);
        	
        	if(!dic.containsKey(key)){
        		dic.put(key, new ArrayList<String>());
        	}
        	dic.get(key).add(s);
        }
        
        dic.forEach((k,v)->{
        	res.add(v);
        });
        return res; 
    }
}
