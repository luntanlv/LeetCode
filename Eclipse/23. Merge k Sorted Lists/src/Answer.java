import java.util.Comparator;
import java.util.PriorityQueue;

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
        ListNode head1 = answer.new ListNode(1);
        ListNode head2 = answer.new ListNode(2);
        ListNode[] list = new ListNode[]{head1, head2};
        
        ListNode res = answer.mergeKLists(list);
        System.out.println(res);       
	}
	
	//Heap
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(k,(a,b) -> Integer.compare(a.val, b.val));
        
//        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(k, new Comparator<ListNode>(){
//        	public int compare(ListNode l1, ListNode l2) { 
//                return l1.val - l2.val; 
//            }
//        });
        
        for(ListNode head: lists){
        	queue.add(head);
        }
        
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        
        while(!queue.isEmpty()){
        	ListNode cur = queue.poll();
        	if(cur.next!=null)
        		queue.add(cur.next);
        	pre.next = cur;
        	pre = cur;
        }
        
        return dummyHead.next;
    }
}
