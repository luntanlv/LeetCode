
public class Answer {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}
	
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        ListNode head = answer.new ListNode(1);
        ListNode node1 = answer.new ListNode(2);
        head.next = node1;
        ListNode res = answer.insertionSortList(head);
        System.out.println(res);       
	}
	
	
	//too slow to write this code
    public ListNode insertionSortList(ListNode head) {
    	ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
    	ListNode handling = head, sortedEnd=fakeHead;
    	
    	while(handling != null){    		
    		ListNode nextHandling = handling.next;
    		ListNode cur = fakeHead;
    		
    		while(cur!=sortedEnd && cur.next.val<handling.val)
    			cur=cur.next;
    		
    		ListNode next = cur.next;
    		cur.next = handling;
    		handling.next= next;
    		
    		if(cur == sortedEnd){
    			sortedEnd = handling;
    			sortedEnd.next=null;
    		}    			
    		
    		handling = nextHandling;
    	}
    	
    	return fakeHead.next;
    }
    
	//too slow to write this code
    public ListNode insertionSortList_littleBetter(ListNode head) {
    	ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
    	ListNode handling = head;
    	
    	while(handling != null){    		
    		ListNode nextHandling = handling.next;
    		ListNode cur = fakeHead;
    		
    		while(cur.next !=null && cur.next.val<handling.val)
    			cur=cur.next;
    		
    		//always insert after cur
    		ListNode next = cur.next;
    		cur.next = handling;
    		handling.next= next;			
    		
    		handling = nextHandling;
    	}
    	
    	return fakeHead.next;
    }
}
