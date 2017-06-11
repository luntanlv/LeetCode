import java.util.Arrays;

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
        //boolean res = answer.hasCycle(head);
        ListNode res = answer.detectCycle(head);
        System.out.println(res);       
	}
	
    public boolean hasCycle(ListNode head) {
    	ListNode fast = head, slow = head;
    	while(fast != null && slow != null){
    		slow=slow.next;
    		fast=fast.next;
    		
    		if(fast!=null)
    			fast=fast.next;
    		else
    			break;
  		
    		if(fast == slow)
    			return true;
    	}
    	return false;
    }
    
    //I saw the solution
    //https://discuss.leetcode.com/topic/2975/o-n-solution-by-using-two-pointers-without-change-anything
    public ListNode detectCycle(ListNode head) {
    	ListNode fast = head, slow = head;
    	ListNode meetingPoint = null;
    	while(fast != null && slow != null){
    		slow=slow.next;
    		fast=fast.next;
    		
    		if(fast!=null)
    			fast=fast.next;
    		else
    			break;
  		
    		if(fast == slow){
    			meetingPoint = fast;
    			break;
    		}
    			
    	}
    	
    	if(meetingPoint == null)
    		return null;
    	
    	ListNode startAgain = head;
    	while(startAgain != meetingPoint){
    		meetingPoint = meetingPoint.next;
    		startAgain = startAgain.next;
    	}
    	
    	return startAgain;
    }
}
