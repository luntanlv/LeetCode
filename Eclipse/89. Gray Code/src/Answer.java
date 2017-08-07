import java.util.ArrayList;
import java.util.List;

public class Answer {
	
	//https://discuss.leetcode.com/topic/608/what-if-i-have-no-knowledge-over-gray-code-before/3
	
	//http://www.jiuzhang.com/solutions/gray-code/
	//http://www.cnblogs.com/yuzhangcmu/p/4121804.html
	public static void main(String [] args)
	{
        Answer answer = new Answer();             
        System.out.println("");       
	}
	
	
	//I just saw the solution
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        if (n == 0) {
            ret.add(0);
            return ret;
        }
        
        ret = grayCode(n - 1);
        
        for (int i = ret.size() - 1; i >= 0; i--) {
            int num = ret.get(i);
            num += 1 << (n - 1);
            ret.add(num);
        }
        
        return ret;
    }
}
