import java.util.PriorityQueue;
import java.util.Queue;

public class Answer {

    private Queue<Integer> l;
    private Queue<Integer> r;
                        
    
    /** initialize your data structure here. */
    public Answer() {
        this.l = new PriorityQueue<>((a,b)-> b-a);
        this.r = new PriorityQueue<>();        
    }
    
    public void addNum(int num) {
    	//Need add to left and spread data to right, think case 1,2,3
        l.add(num);
        r.add(l.poll());  
            
        if(l.size()<r.size()){
            l.add(r.poll());     
        }
    }
    
    public double findMedian() {
        if(l.size() == r.size())
            return ((double)l.peek()+(double)r.peek())/2;
        else if(l.size() > r.size())
            return l.peek();
        else 
            return r.peek();     
    }
}
