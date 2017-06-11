import java.util.HashMap;

public class Anwser {
	public static void main(String [] args)
	{
		Anwser answer = new Anwser();     
	}	
	
	class DoubleListNode {
		int val;
		int key;
		DoubleListNode next;
		DoubleListNode pre;
		DoubleListNode(int key, int val)
		{
			this.key = key;
			this.val = val;
			next = null;
			pre = null;
		}
	}	
	
	public class LRUCache {
		private HashMap<Integer, DoubleListNode> Dic;
		private DoubleListNode LruListHead;
		private DoubleListNode LruListTail;
		private int Capacity;
		
	    public LRUCache(int capacity) {
	        this.Capacity = capacity;
	        this.Dic = new HashMap<Integer,DoubleListNode>();
	        DoubleListNode fakeHeadNode = new DoubleListNode(-1,-1);
	        DoubleListNode fakeTailNode = new DoubleListNode(-1,-1);   
	        fakeHeadNode.next = fakeTailNode;
	        fakeTailNode.pre = fakeHeadNode;
	        this.LruListHead = fakeHeadNode;
	        this.LruListTail = fakeTailNode;
	        
	    }
	    
	    public int get(int key) {
	        if(!Dic.containsKey(key))
	        	return -1;
	        
	        DoubleListNode selected = Dic.get(key);
	        
            //remove from current position in LruList
            selected.pre.next = selected.next;
            selected.next.pre = selected.pre;      
            
            //Readd selected to end of LruList
            LruListTail.pre.next = selected;
            selected.pre = LruListTail.pre;
            LruListTail.pre = selected;
            selected.next = LruListTail;
            
            
	        return selected.val;      
	    }
	    
	    public void put(int key, int value) {
	    	DoubleListNode node2Put= null;
	    	
	    	if(Dic.containsKey(key)){
	    		node2Put = Dic.get(key);
	    		node2Put.val = value;
	    		
	    		//remove from current position, prepair to add to the end of LruList
	    		node2Put.pre.next = node2Put.next;
	    		node2Put.next.pre = node2Put.pre;    
	    	}
	    	else{
	    		node2Put = new DoubleListNode(key, value);
	    		
		    	if(Dic.size()>=this.Capacity){
		        	//Remove the LruList first item
		        	DoubleListNode firstNode = LruListHead.next;
		        	if(firstNode != null){
		        		Dic.remove(firstNode.key);
		        		LruListHead.next = firstNode.next;
		        		firstNode.next.pre = LruListHead;
		        	}
		        	
		        }
	    	}
	    	
            LruListTail.pre.next = node2Put;
            node2Put.pre = LruListTail.pre;
            LruListTail.pre = node2Put;
            node2Put.next = LruListTail;	    	
	    	        
	        Dic.put(key, node2Put); 	
	    }
	}
}
