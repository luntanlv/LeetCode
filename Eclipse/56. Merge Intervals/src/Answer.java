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
        input.add(answer.new Interval(8,9));
        
        //List<Integer> res = answer.spiralOrder(input);
        //System.out.println(res);
        List<Interval> res = answer.merge(input);
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
		
}




