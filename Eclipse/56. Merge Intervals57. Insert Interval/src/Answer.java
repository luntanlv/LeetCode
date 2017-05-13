import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Answer {
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
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
    	if(intervals.isEmpty())
    		return res;
        
        //intervals.sort((o1, o2) ->o1.start - o2.start);
    	intervals.sort(new Comparator<Interval>(){
		   public int compare(Interval o1, Interval o2)
		   {
			   return o1.start - o2.start;
		   }    		
    	});        
        
        Interval first = intervals.get(0);
        int start=first.start, end=first.end;
        for(Interval item: intervals){
        	if(item.start<=end){
        		end = item.end<end? end: item.end;
        	}
        	else{
        		Interval resItem = new Interval(start, end);
        		res.add(resItem);
        		start = item.start;
        		end = item.end;
        	}
        }
        
        res.add(new Interval(start, end));
        
        return res;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> res = new ArrayList<Interval>();
     	if(intervals.isEmpty()){
     		res.add(newInterval);
     		return res;
     	}
     	
     	Interval previous = null;
     	Interval last = intervals.get(intervals.size()-1);
     	
        int start = newInterval.start, end=newInterval.end;
        boolean foundOverlap = false;
 
        for(Interval item: intervals){    	
        	if((previous == null || previous.end<newInterval.start) && item.start>newInterval.end)
        		res.add(newInterval);
        	
        	//newInterval totally after item; totally before item; totally inside just one item
        	if(item.end<newInterval.start || item.start>newInterval.end || (item.start<=newInterval.start && item.end>= newInterval.end)){        		
        		if(foundOverlap){
        			foundOverlap=false;
        			res.add(new Interval(start, end));
        		}
        		res.add(item);   		
        	}
        	else{
        		start = Math.min(item.start, start);
        		end = Math.max(item.end, end);
        		foundOverlap =true;
        	}
        	previous = item;
        }
        
		if(foundOverlap){
			res.add(new Interval(start, end));
		}
     	if(last.end<newInterval.start)
     		res.add(newInterval);
           
        return res;    		
    }

    //this is leetcode solution, we can actually modify newInterval's start and end during the loop!!
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        for (Interval i : intervals) {
            if (newInterval == null || i.end < newInterval.start)
                result.add(i);
            else if (i.start > newInterval.end) {
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        if (newInterval != null)
            result.add(newInterval);
        return result;
    }
}




