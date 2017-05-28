
public class Answer {
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
    
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        ListNode head = answer.new ListNode(0);
        ListNode node1 = answer.new ListNode(1);
        head.next=node1;
        ListNode node2 = answer.new ListNode(2);
        node1.next = node2;
        ListNode node3 = answer.new ListNode(3);
        node2.next = node3;
        ListNode node4 = answer.new ListNode(4);
        node3.next = node4;
        ListNode node5 = answer.new ListNode(5);
        node4.next = node5;
        
        TreeNode res = answer.sortedListToBST(head);
        System.out.println(res);       
	}    
    
	public TreeNode sortedListToBST(ListNode head) {
	    if(head==null) return null;
	    return toBST(head,null);
	}
	//[head, tail)
	public TreeNode toBST(ListNode head, ListNode tail){
	    ListNode slow = head;
	    ListNode fast = head;
	    if(head==tail) return null;
	    
	    while(fast!=tail&&fast.next!=tail){
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    TreeNode thead = new TreeNode(slow.val);
	    thead.left = toBST(head,slow);
	    thead.right = toBST(slow.next,tail);
	    return thead;
	}
}
