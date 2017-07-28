import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Answer {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        List<Interval> input = new ArrayList<Interval>();
        input.add(answer.new Interval(1,3));
        input.add(answer.new Interval(3,6));
        input.add(answer.new Interval(8,10));
        input.add(answer.new Interval(15,18));
        //input.add(answer.new Interval(8,9));
        
        //List<Interval> res = answer.merge(input);
        
        
        List<Interval> input2 = new ArrayList<Interval>();
        input2.add(answer.new Interval(2,4));
        input2.add(answer.new Interval(5,7));
        input2.add(answer.new Interval(8,10));
        input2.add(answer.new Interval(11,13));
        List<Interval> res = answer.insert(input2, answer.new Interval(3,8));
        
        for(Interval item: res){
        	System.out.print("[" + item.start + "," + item.end +"], ");
        }
	}
	
	//252
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a,b)-> a.start-b.start);
        int maxEnd = Integer.MIN_VALUE;
        for(Interval cur : intervals){
        	if(cur.start<maxEnd)
        		return false;
        	maxEnd = Math.max(maxEnd, cur.end);
        }
        return true;
    }
    
    //253
    //A faster solution, but little bit hard to understand
    //https://discuss.leetcode.com/topic/35253/explanation-of-super-easy-java-solution-beats-98-8-from-pinkfloyda
    //solution 3, a little bit easier to understand
    //https://leetcode.com/problems/meeting-rooms-ii/tabs/discuss
    public int minMeetingRooms(Interval[] intervals) {
    	Arrays.sort(intervals, (a,b)-> a.start-b.start);
    	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    	int count=0;
    	for(Interval cur : intervals){
    		while(!minHeap.isEmpty() && minHeap.peek()<=cur.start){
    			minHeap.remove();
    		}
    		minHeap.add(cur.end);
    		count = Math.max(count, minHeap.size());
    	}
    	
    	return count;
    }
}
