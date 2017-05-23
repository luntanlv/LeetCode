
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();   
        System.out.println();           
	}
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
    	dummyHead.next = head;
    	ListNode cur = head;
    	ListNode pre = dummyHead;
    	ListNode nodeBeforeRe = null;
    	
    	int index =1;
    	while(cur != null && index <=n){
    		if(index<m){
    			pre=cur;
    			cur= cur.next;
    		}
    		else if(index ==m){
    			nodeBeforeRe = pre;
    			pre=cur;
    			cur= cur.next;
    		}
    		else if(index == n){
    			ListNode next = cur.next;
    			cur.next = pre;
    			nodeBeforeRe.next.next = next;
    			nodeBeforeRe.next = cur;		
    		}
    		else{
    			ListNode next = cur.next;
    			cur.next = pre;
    			pre=cur;
    			cur= next;			
    		} 
    		index++;
    	}
    	return dummyHead.next;
    	
    }
    
    public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
