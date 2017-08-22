import java.util.ArrayList;
import java.util.List;

public class Answer {
	
	//https://discuss.leetcode.com/topic/608/what-if-i-have-no-knowledge-over-gray-code-before/3
	/*
		I don't think it's a knowledge base problem. It's also my first time to hear about Gray Code. But after trying some small cases, 
		I still figured out an algorithm for it.
		
		From my intuition, the problem is like Hanoi. If you're able to solve n = 2 case, then you can kind of repeat it twice to achieve n = 3 case.
		Lets try to extend n = 2 case to n = 3 case first.
		
		When n = 2, the sequence is
		00 -> 01 -> 11 -> 10
		If you want to extend it to n=3 directly without modifying old part, there are only two possible sequence, and they are not hard to find out.
		
		000 -> 001 -> 011 -> 010 -> 110 -> 111 -> 101 -> 100
		
		000 -> 001 -> 011 -> 010 -> 110 -> 100 -> 101 -> 111
		
		So now, the problem is, which one should we choose. I would choose the first one for two reasons.
		
		The last elements have similar form in both n=2 and n=3 case. They are 1 follows bunch of 0's. 
		Since we hope to extend the same algorithm to n=4 n=5... cases. It's good to preserve some properties.
		
		If we only look at the last 2 digits, we can see that in the first sequence, 
		the second half is exact the reverse of the first half, that means, we can systematically generate the second half according to the first half.
		
		That's how I figured out the algorithm. Hope that helps! 
	 */
	
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
