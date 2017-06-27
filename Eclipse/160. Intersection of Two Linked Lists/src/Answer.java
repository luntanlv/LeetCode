
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
        ListNode head1 = answer.new ListNode(1);
        ListNode head2 = answer.new ListNode(2);
        ListNode node = answer.new ListNode(3);
        head1.next = node;
        head2.next = node;
        ListNode res = answer.getIntersectionNode_2(head1, head2);
        System.out.println(res.val);       
	}
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA =0, lenB = 0;
        ListNode curA = headA;
        while(curA!=null){
        	lenA++;
        	curA=curA.next;
        }
        
        ListNode curB = headB;
        while(curB!=null){
        	lenB++;
        	curB=curB.next;
        }
        
        int lenDiff = lenA-lenB;
        curA=headA;
        curB=headB;
        while(lenDiff!=0){
        	if(lenDiff>0){
        	    curA=curA.next;
        	    lenDiff--;
        	}
        	else{
        		curB=curB.next;
        		lenDiff++;
        	}
        }
        
        while(curA!=null && curB!=null){
        	if(curA==curB)
        		return curA;
        	curA=curA.next;
        	curB=curB.next;
        }
        return null;
    }
    
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
    	ListNode curA = headA;
    	ListNode curB = headB;
    	boolean isASwitch=false, isBSwitch =false;
    	while(curA!=null && curB!=null){
    		if(curA==curB)
    			return curA;
    		
    		curA=curA.next;
    		curB=curB.next;
    		
    		if(curA==null && !isASwitch){
    			curA=headB;
    			isASwitch=true;			
    		}
    			
    		
    		if(curB==null && !isBSwitch){
    			curB=headA;
    			isBSwitch = true;
    		}
    	}
    	return null;
    }
    
    public ListNode getIntersectionNode_2Concise(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
        	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }
        
        return a;
    }
    
    
}
