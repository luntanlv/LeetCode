import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        //int[] fields = new int[]{1,3,-1,-3,5,3,6,7};
        int[] fields = new int[0];
        int res[] = answer.maxSlidingWindow(fields, 0);
        for(int r: res)
        	System.out.print(r+", ");
	}
	
	//I saw the solution
	//Monotonic Queue
	//https://abitofcs.blogspot.com/2014/11/data-structure-sliding-window-minimum.html
	public int[] maxSlidingWindow(int[] a, int k) {		
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}	
	
	//Using heap O(nlogk)
    public int[] maxSlidingWindow_mysolu(int[] nums, int k) {
    	if(nums.length==0 || k>nums.length)
    		return new int[0];
    	
    	//Max heap, store index
        PriorityQueue<Integer> heap =  new PriorityQueue<>((a,b)->nums[b]-nums[a]);
        int[] res = new int[nums.length-k+1];
        
        for(int i=0; i<nums.length; i++){
        	heap.add(i);
        	if(heap.size()==k){   		
        		res[i-k+1]=nums[heap.peek()];
        		heap.remove(i-k+1);
        	}       	
        }
        return res;
    }
}
