
public class Answer {
	//Definition for singly-linked list.
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
        head.next = head;
        answer.reorderList(head);
        System.out.println(head);       
	}
	
	//even node num case: 1,2,3, 4,5,6 -> 1,6,2,5,3,4, point to start reverse 4, so fast move 5, slow need move 3
	//odd node num case: 1,2,3,4,5,6,7 -> 1,7,2,6,3,5,4, point to start reverse 5
	//
    public void reorderList(ListNode head) {
    	if(head == null)
    		return;
    	
        //First: find middle point
    	ListNode fast = head, slow = head;
    	while(fast.next != null){
    		fast=fast.next;
    		slow=slow.next;
    		
    		//because of the even node num case
    		if(fast.next!=null)
    			fast=fast.next;
    	}
    	ListNode mid = slow, tail = fast;
    	
    	//Second: reverse mid to tail
    	ListNode cur = mid, pre = null;
    	while(cur != null){
    		ListNode next = cur.next;
    		cur.next =pre;
    		pre = cur;
    		cur = next;
    	}
    	
    	//Thrid: combine two part to reordered list
    	ListNode curForward = head, curBackward = tail;
    	
    	//for even node num case && for odd node num case
    	while(curBackward != null && curForward != curBackward){
    		ListNode nextForward = curForward.next;
    		ListNode nextbackward = curBackward.next;
    		
    		curForward.next = curBackward;
    		//For even node num case, to prevent loop
    		if(nextForward != curBackward)
    			curBackward.next = nextForward;
    		
    		curForward = nextForward;
    		curBackward = nextbackward;
    	}
    	
    }
}



