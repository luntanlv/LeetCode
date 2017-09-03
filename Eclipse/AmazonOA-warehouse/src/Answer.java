import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        List<int[]> fields = new ArrayList<>();
        fields.add(new int[]{2,3});
        fields.add(new int[]{3,4});
        fields.add(new int[]{1,-3});
        //fields.add(new int[]{2,3});
        //fields.add(new int[]{3,3});
        
        
        List<int[]> res = answer.topKPoint(fields, 2);
        for(int[] item: res)
        	System.out.println(item[0]+", "+item[1]);
	}
	
	/*
	 * amazon warehouse��������ʵ���Ǹ��� x,y Ȼ���� x,y ��ԭ��ľ���,�����С�ļ���,java Ӧ��priorityqueue �͹���
	 * int N, �����ܹ���N ���ص�
		List<List<Integer>> �ص������
		int M,������Ҫ�͵�crate����
		
		output��һ��List<List<Integer>> �����ͻ��ĵص�����x,y. 
		��ʵ�������������뿨�������M���ص�.
		
		��Ҫע�������Ŀ����û�и�������λ�ã����ݸ������Ӳ³���ԭ�㣨0��0��
		��1��N = 3, M = 2, List<List<Ingeter>> �� [[2,3][3,4],[1,-3]].
		output: [[2,3],[1,-3]]
		
		��2�� N=3�� M=6�� List<List<Integer>> ��[[1,8],[2,4],[8,9],[5,3],[2,7],[3,5]].
		output: [[2,4],[5,3],[3,5]].
	 */
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
