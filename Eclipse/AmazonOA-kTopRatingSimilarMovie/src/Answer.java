import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Answer {

	public class Movie{
		public int id;
		public float rate;
		public List<Movie> similarMovies;
		
		public Movie(int _id, float _rate){
			id=_id;
			rate = _rate;
			similarMovies = new ArrayList<>();
		}
	}
	
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        Movie m = answer.new Movie(0,1);
        Movie m1 = answer.new Movie(1,1);
        Movie m2 = answer.new Movie(2,2);
        Movie m3 = answer.new Movie(3,3);
        Movie m4 = answer.new Movie(4,9);
        Movie m5 = answer.new Movie(5,8);
        Movie m6 = answer.new Movie(6,7);
        Movie m7 = answer.new Movie(7,6);
        
        m.similarMovies.add(m1);
        m.similarMovies.add(m2);
        m.similarMovies.add(m3);
        m1.similarMovies.add(m3);
        m1.similarMovies.add(m4);
        m2.similarMovies.add(m4);
        m2.similarMovies.add(m1);
        m2.similarMovies.add(m2);
        m2.similarMovies.add(m5);
        m5.similarMovies.add(m5);
        m5.similarMovies.add(m6);
        m5.similarMovies.add(m7);
        
        
        List<Movie> res = answer.find(m7, 99);
        for(Movie mov: res)
        	System.out.println(mov.id);
	}
	
	//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=244701&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B5%5D%3D5%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%
	/*
	 * 第二题是在 Movie network 里寻找 N 个分数最高的 Movie,
		第二题是给一个 movie,每个 movie 有 id,rating 和一个 list of neighbors,
		让你从这个 movie 开始,找到 similar 的 top k rating movie,不包括这个 movie。
		用 bfs 遍历这个图,然后再用一个 minHeap,每次分两种情况,如果 minHeap.size()== k,
		那就看是不是比 peek 的 rating 大,如果大就扔出来一个把这个新的放进去。如果 minHeap.size() < k
		,就放进去。最后结果就在 minHeap 里面。
	 */
	List<Movie> find(Movie movie, int k){
		List<Movie> res = new ArrayList<>();
		if(movie==null)
			return res;
		
		Queue<Movie> q = new LinkedList<>();
		HashSet<Integer> visited =  new HashSet<>();
		PriorityQueue<Movie> pq = new PriorityQueue<>((b, a) -> {
			if(a.rate<b.rate)
				return -1;
			else if(a.rate>b.rate)
				return 1;
			else
				return 0;
		});
		
		q.add(movie);
		visited.add(movie.id);
		//not include itself
		//pq.add(movie);
		
		while(!q.isEmpty()){
			Movie cur = q.poll();
			
			for(Movie mov : cur.similarMovies){
				if(!visited.contains(mov.id)){
					visited.add(mov.id);
					q.add(mov);
					pq.add(mov);
				}
			}
		}
		
		
		for(int i=0; !pq.isEmpty() && i<k; i++){
			res.add(pq.poll());
		}
		
		return res;
	}
}
