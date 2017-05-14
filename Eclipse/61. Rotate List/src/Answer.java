
public class Answer {
	public static void main(String [] args)
	{      
		Answer answer = new Answer();
		
		ListNode head = answer.new ListNode(1);
		ListNode node2 = answer.new ListNode(2);
		ListNode node3 = answer.new ListNode(3);
		ListNode node4 = answer.new ListNode(4);
		head.next=node2;
		node2.next = node3;
		node3.next = node4;
		
		ListNode res  = answer.rotateRight(head, 1000004);
		
    	while(res !=null){
    		System.out.print(res.val +", ");
    		res = res.next; 			
    	}
        
	}
	
    public ListNode rotateRight(ListNode head, int k) {
    	//for empty and list with 1 node
    	if(head==null || head.next== null)
    		return head;
    	
    	int len=1;
    	ListNode end = head;
    	
    	while(end.next !=null){
    		end = end.next; 		
    		len++;
    	}
    	
    	k=k%len;
    	
    	ListNode newEnd = head;
    	for(int i=0; i<len-k-1; i++){
    		newEnd=newEnd.next;
    	}
    	
    	end.next = head;
    	head = newEnd.next;
    	newEnd.next = null;
    		
        return head;
    }
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
}
