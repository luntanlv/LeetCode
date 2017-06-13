
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
        ListNode res = answer.sortList(head);
        System.out.println(res);       
	}	
	
	// I saw the solution
	// https://discuss.leetcode.com/topic/10382/bottom-to-up-not-recurring-with-o-1-space-complextity-and-o-nlgn-time-complextity
    public ListNode sortList(ListNode head) {
        
    }
}
