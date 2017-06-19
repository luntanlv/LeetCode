
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
        answer.deleteNode(head);
        System.out.println(head);       
	}
	
    public void deleteNode(ListNode node) {
        if(node.next == null)
        	return;
        
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
