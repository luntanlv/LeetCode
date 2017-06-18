import java.util.Stack;

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
    //O(n)
    public ListNode addTwoNumbers_rverse_nspace(ListNode l1, ListNode l2) {
        Stack<ListNode> st1 = new Stack<ListNode>();
        Stack<ListNode> st2 = new Stack<ListNode>();
        
        while(l1!=null){
        	st1.add(l1);
        	l1=l1.next;
        }
        
        while(l2!=null){
        	st2.add(l2);
        	l2=l2.next;
        }
        
        ListNode pre = null;
        int c =0;
        while(!st1.isEmpty() || !st2.isEmpty() || c>0){
        	int val1 = st1.isEmpty()? 0: st1.pop().val;
        	int val2 = st2.isEmpty()? 0: st2.pop().val;
        	
        	int sum =  val1+val2+c;
        	ListNode newNode = new ListNode(sum%10);
			c= sum/10;
			
			newNode.next = pre;
			pre= newNode;
        }
        
        return pre;
    }
    
    //O(1) extra space
    //I saw the solution
    //Idea is to reverse output instead of input
    public ListNode addTwoNumbers_reverse_1space(ListNode l1, ListNode l2) {
    	int n1=0, n2=0;
    	ListNode curl1 = l1, curl2 =l2;
        while(curl1!=null){
        	n1++;
        	curl1=curl1.next;
        }      
        while(curl2!=null){
        	n2++;
        	curl2=curl2.next;
        }
        
        int cur1 = n1, cur2=n2;
        curl1 = l1;
        curl2 =l2;
        ListNode reverseOrderHead = null;
        while(cur1>0 && cur2>0){
        	int sum =0;
        	if(cur1>cur2){
        		sum = curl1.val;
        		curl1 = curl1.next;
        		cur1--;
        	}
        	else if(cur2>cur1){
        		sum = curl2.val;
        		curl2 = curl2.next;
        		cur2--;
        	}
        	else{
        		sum = curl1.val + curl2.val;
        		curl1 = curl1.next;
        		curl2 = curl2.next;
        		cur1--;
        		cur2--;
        	}
        	
        	//Add sum in reversed order, so least significant num is the head
        	ListNode newSum = new ListNode(sum);
        	newSum.next = reverseOrderHead;
        	reverseOrderHead = newSum;
        }
        
        //Start from least significant num, calculate carry and reverse order back to original order: most significant -> least significant
        ListNode cur = reverseOrderHead, pre= null;
        int c=0;
        while(cur != null){
        	int sum = cur.val + c;
        	cur.val = sum%10;
        	c = sum/10;
        	
        	ListNode next = cur.next;
        	cur.next = pre;
        	pre = cur;
        	cur = next;
        }
        
        ListNode newHead;
        if(c>0){
        	newHead = new ListNode(c);
        	newHead.next = pre;
        }
        else{
        	newHead = pre;
        }
              
        return newHead;
    }    
}
