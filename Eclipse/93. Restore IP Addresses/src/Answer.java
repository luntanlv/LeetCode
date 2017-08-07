import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        String input = "1111";
        List<String> res = answer.restoreIpAddresses(input);
        for(String str: res){
        	System.out.println(str);     
        }       
	}
	
    public List<String> restoreIpAddresses(String s) {
    	List<String> res =  new ArrayList<String>();
    	backTracking(s, res, new StringBuilder(), 0, 0);
    	
    	return res;
    }
    
    private void backTracking(String s, List<String> res, StringBuilder cur, int startIndex, int ipPart){
    	if(ipPart==4 && startIndex==s.length()){
    		res.add(cur.toString());
    		return;
    	}
    	else if((ipPart==4 && startIndex<s.length()) || startIndex>=s.length())
    		return;
    	
    	//i: Num of dig
    	for(int i=1; i<4; i++){
    		if(startIndex+i-1 >= s.length())
    			break;
    		int dig = Integer.valueOf(s.substring(startIndex, startIndex+i));
    		if( (i==2 && dig<10) || (i==3 && (dig<100 || dig>255)))
    			continue;
    		
    		String appendent = cur.length()==0? String.valueOf(dig) : "." + String.valueOf(dig);
    		cur.append(appendent);
    		backTracking(s, res, cur, startIndex+i,ipPart+1);
    		cur.delete(cur.length()-appendent.length(), cur.length());    	
    		
    	}
    }
}
