import java.util.Stack;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        MyQueue obj = answer.new MyQueue();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);       
	}
	
	public class MyQueue {
		
		private Stack<Integer> pushSt;
		private Stack<Integer> popSt;

	    /** Initialize your data structure here. */
	    public MyQueue() {
	    	pushSt = new Stack<Integer>();
	    	popSt = new Stack<Integer>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        pushSt.push(x);
	    }	    
//	    public void push(int x) {
//	        while(!popSt.isEmpty()){
//	        	int temp = popSt.pop();
//	        	pushSt.push(temp);
//	        }
//	        pushSt.push(x);
//	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	    	this.peek();
	    	return popSt.pop();
	    }
//	    public int pop() {
//	        while(!pushSt.isEmpty()){
//	        	int temp = pushSt.pop();
//	        	popSt.push(temp);
//	        }
//	        
//	        if(!popSt.isEmpty())
//	        	return popSt.pop();
//	        else return -1;
//	    }
	    
	    /** Get the front element. */
	    public int peek() {
	    	if(popSt.isEmpty()){
		        while(!pushSt.isEmpty()){
		        	int temp = pushSt.pop();
		        	popSt.push(temp);
		        }	    		
	    	}
	    	
	    	return popSt.peek();
    	}	    
//	    public int peek() {
//	        while(!pushSt.isEmpty()){
//	        	int temp = pushSt.pop();
//	        	popSt.push(temp);
//	        }
//	        
//	        if(!popSt.isEmpty())
//	        	return popSt.peek();
//	        else return -1;
//	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return popSt.isEmpty() && pushSt.isEmpty();
	    }
	}	
}
