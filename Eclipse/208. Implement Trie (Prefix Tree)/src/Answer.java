import java.util.HashMap;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        Trie obj = answer.new Trie();
        obj.insert("word");
        boolean param_2 = obj.search("word");
        boolean param_3 = obj.startsWith("worf");
        System.out.println(param_2);
        System.out.println(param_3);  
	}
	
	public class ListNode {
		public char val;
		//indicate whether a word end here.
		public boolean isEnd;
		public HashMap<Character, ListNode> ChildrenMap;
		ListNode(char x)
		{
			val = x;
			ChildrenMap = new HashMap<Character, ListNode>();
		}
	}
	
	public class Trie {
		ListNode root;

	    /** Initialize your data structure here. */
	    public Trie() {
	    	root = new ListNode('0');
	    }
	    
	    /** Inserts a word into the trie. */
	    //The path need to end when word ends
	    public void insert(String word) {
	        char[] wordChr = word.toCharArray();
	        ListNode cur = root;
	        
	        for(int i=0; i<wordChr.length; i++){
	        	if(!cur.ChildrenMap.containsKey(wordChr[i])){
	        		ListNode next = new ListNode(wordChr[i]);
	        		cur.ChildrenMap.put(wordChr[i], next);
	        		cur= next;
	        	}
	        	else{
	        		cur=cur.ChildrenMap.get(wordChr[i]);
	        	}
	        }
	        
	        cur.isEnd = true;
	    }
	    
	    /** Returns if the word is in the trie. */
	    //The path need to end when word ends
	    public boolean search(String word) {
	        char[] wordChr = word.toCharArray();
	        ListNode cur = root;
	        
	        for(int i=0; i<wordChr.length; i++){
	        	if(!cur.ChildrenMap.containsKey(wordChr[i]))
	        		return false;
	        	else{
	        		cur = cur.ChildrenMap.get(wordChr[i]);
	        	}
	        }
	        
	        return cur.isEnd;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        char[] wordChr = prefix.toCharArray();
	        ListNode cur = root;
	        
	        for(int i=0; i<wordChr.length; i++){
	        	if(!cur.ChildrenMap.containsKey(wordChr[i]))
	        		return false;
	        	else{
	        		cur = cur.ChildrenMap.get(wordChr[i]);
	        	}
	        }
	        
	        return true;
	    }
	}
}
