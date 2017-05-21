
public class Answer {
	
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{1,1,1,2,2,2,2,3,3};
        //char[][] input = new char[][]{{'A'}};
        int res = answer.removeDuplicates(input);
        
        System.out.println(res);
        for(int num: input){
        	 System.out.print(num+", ");
        }
            
	}	
	
	//82
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
            
        ListNode falkeHead = new ListNode(Integer.MIN_VALUE);
        falkeHead.next=head;
        ListNode cur = head;
        ListNode pre = falkeHead;
        
        while(cur != null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
        	//no dup
            if(pre.next==cur){
                pre=pre.next;
            }
            //dup
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        
        return falkeHead.next;
    }
	
    //83
    public ListNode deleteDuplicates83(ListNode head) {
        if(head==null)
            return head;
            
        ListNode falkeHead = new ListNode(Integer.MIN_VALUE);
        falkeHead.next=head;
        ListNode cur = head;
        ListNode pre = falkeHead;
        
        while(cur != null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            
            pre.next = cur;
            pre = cur;
            cur=cur.next;
        }
        return falkeHead.next;
    }
    
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
