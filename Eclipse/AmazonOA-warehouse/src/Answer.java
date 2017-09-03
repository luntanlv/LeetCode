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
	 * amazon warehouse。。。其实就是给你 x,y 然后算 x,y 到原点的距离,输出最小的几个,java 应该priorityqueue 就够了
	 * int N, 代表总共有N 个地点
		List<List<Integer>> 地点的坐标
		int M,代表需要送的crate数量
		
		output：一个List<List<Integer>> 代表送货的地点坐标x,y. 
		其实就是让你计算距离卡车最近的M个地点.
		
		需要注意点是题目里面没有给卡车的位置，根据给的例子猜出是原点（0，0）
		例1：N = 3, M = 2, List<List<Ingeter>> 是 [[2,3][3,4],[1,-3]].
		output: [[2,3],[1,-3]]
		
		例2： N=3， M=6， List<List<Integer>> 是[[1,8],[2,4],[8,9],[5,3],[2,7],[3,5]].
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
