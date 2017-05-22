import Answer.ListNode;

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
	
    public ListNode partition(ListNode head, int x) {
    	ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
    	dummyHead.next =head;
    	
    	ListNode smallerHead= new ListNode(Integer.MIN_VALUE);
    	ListNode smallerCur= smallerHead;
    	
    	ListNode pre= dummyHead, cur = head;
    	
    	while(cur!=null){
    		if(cur.val<x){
    			smallerCur.next = cur;
    			smallerCur = cur;
    			pre.next = cur.next;
    			cur= cur.next;
    		}
    		else{
        		pre=cur;
        		cur=cur.next;
    		}		
    	}
    	
    	smallerCur.next = dummyHead.next;
    	return smallerHead.next;
    	
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
