import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        List<int[]> fields = new ArrayList<>();
        fields.add(new int[]{3,1});
        fields.add(new int[]{1,1});
        fields.add(new int[]{2,2});
        fields.add(new int[]{2,3});
        fields.add(new int[]{3,3});
        
        
        List<int[]> res = answer.topKPoint(fields, 3);
        for(int[] item: res)
        	System.out.println(item[0]+", "+item[1]);
	}
	
	public List<int[]> topKPoint(List<int[]> points, int k){
		if(k>=points.size())
			return points;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1])); 
		for(int[] point: points){
			pq.add(point);
		}
		
		List<int[]> res = new ArrayList<>();
		for(int i=0; i<k; i++){
			res.add(pq.poll());
		}
		
		return res;
	}
}
