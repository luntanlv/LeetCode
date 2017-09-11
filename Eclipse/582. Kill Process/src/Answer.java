import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Answer {

	public static void main(String [] args)
	{
        Answer answer = new Answer();  
        System.out.println();
	}
	
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> p2c = new HashMap<>();

        for(int i=0; i<ppid.size(); i++){
        	int p = ppid.get(i);
        	int c = pid.get(i);
        	
        	if(!p2c.containsKey(p))
        		p2c.put(p, new ArrayList<Integer>());
        	p2c.get(p).add(c);
        }
        
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q =  new LinkedList<>();
        
        q.add(kill);
        
        while(!q.isEmpty()){
        	int cur = q.poll();
        	res.add(cur);
        	
        	if(p2c.containsKey(cur)){
            	for(int c: p2c.get(cur)){
            		q.add(c);
            	}
        	}

        }
        
        return res;
    }
}
