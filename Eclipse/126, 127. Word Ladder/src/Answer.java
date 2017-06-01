import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        String[] temp = new String[] {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(temp);
        int res = answer.ladderLength("hit", "cog",  wordList);
        System.out.println(res);       
	}
	
	//127
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	List<String> path = new ArrayList<String>();
    	path.add(beginWord);
    	return backtrack(endWord, wordList, path);
    }
    
    private int backtrack(String end, List<String> wordList, List<String> path){
    	String cur = path.get(path.size()-1);
    	if(cur.equals(end))
    		return path.size();
    	else if(path.size()-1 == wordList.size())
    		return 0;
    	
    	int minJump = 0;
    	for(int i=0; i<wordList.size(); i++){
    		String trans = wordList.get(i);
    		
    		if(path.contains(trans) || !canTransfer(cur, trans))
    			continue;
    		
    		path.add(trans);
    		int newlen = backtrack(end, wordList, path);
    		minJump = minJump==0 || (newlen>0 && newlen < minJump) ? newlen : minJump;
    		path.remove(path.size()-1);
    	}
    	
    	return minJump;
    }
    
    private boolean canTransfer(String word1, String word2){
    	int difCount =0;
    	for(int i=0; i<word1.length(); i++){
    		if(word1.charAt(i)!=word2.charAt(i))
    			difCount++;
    	}
    	
    	return difCount ==1;
    }
}
