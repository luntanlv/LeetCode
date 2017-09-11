import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();  
        System.out.println();
	}	
	
	//I saw the solution
	//https://discuss.leetcode.com/topic/55377/simple-java-dfs-solution
	//Tree dfs, pre-order
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;++i){
          dfs(i, n, res); 
        }
        return res;
    }
    
    public void dfs(int cur, int n, List<Integer> res){
        if(cur>n)
            return;
        else{
            res.add(cur);
            for(int i=0;i<10;++i){
            	//When next level value larger than n, we should stop DFS in this path now
                if(10*cur+i>n)
                    return;
                dfs(10*cur+i, n, res);
            }
        }
    }
}
