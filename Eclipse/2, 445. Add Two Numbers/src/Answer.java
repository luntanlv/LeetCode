
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
        ListNode head1 = answer.new ListNode(9);
        ListNode head2 = answer.new ListNode(3);
       
        //boolean res = answer.hasCycle(head);
        ListNode res = answer.addTwoNumbers(head1, head2);
        System.out.println(res);       
	}
	
	//2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	ListNode dummyHead = new ListNode(0);
    	ListNode cur1= l1, cur2=l2, pre=dummyHead;
    	int c=0;
    	
    	while(cur1 != null || cur2 != null || c>0){
    		
    		ListNode nextNode = null;
    		if(cur1 != null && cur2 != null){
    			int sum = cur1.val + cur2.val + c;
    			nextNode = new ListNode(sum%10);
    			c= sum/10;
    			
    			cur1= cur1.next;
    			cur2= cur2.next;
    		}
    		else if(cur1 == null && cur2 == null && c>0){
    			nextNode = new ListNode(c);
    			c=0;
    		}
    		else{
    			nextNode = cur1 == null? cur2 : cur1;
    			
    			int sum = nextNode.val + c;
    			nextNode.val = sum%10;
    			c = sum/10;
    			
    			cur1 = cur1==null? null: cur1.next;
    			cur2 = cur2==null? null: cur2.next;
    		}
    		
			pre.next = nextNode;
			pre = nextNode;
    	}
    	
    	return dummyHead.next;
    }
    
    //445. Add Two Numbers II
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    }
    
    private int helper(ListNode l1, ListNode l2){
    	
    }
    
    
}
