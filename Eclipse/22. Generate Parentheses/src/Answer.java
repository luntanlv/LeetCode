import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        List<String> res = answer.generateParenthesis(3);
        System.out.println(res);       
	}
	
    public List<String> generateParenthesis(int n) {
    	List<String> res = new ArrayList<String>();
    	backtracking(res, new StringBuilder(), 0, 0, n);
    	return res;
    }
    
    private void backtracking(List<String> res, StringBuilder cur, int l, int r, int n){
    	if(l==n && r ==n){
    		res.add(cur.toString());
    		return;
    	}
    	
    	if(l<n){
	    	cur.append("(");
	    	backtracking(res, cur, l+1, r, n);
	    	cur.deleteCharAt(cur.length()-1);
    	}
	    	
    	if(l>r && r<n){
    		cur.append(")");
    		backtracking(res, cur, l, r+1, n);
    		cur.deleteCharAt(cur.length()-1);
    	}
    		
    	return;
    }
}
