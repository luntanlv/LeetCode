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
    	
    	int oneDig = Integer.valueOf(s.substring(startIndex, startIndex+1));
    	if(oneDig>=0){
        	String appendent = cur.length()==0? String.valueOf(oneDig) : "." + String.valueOf(oneDig);
        	cur.append(appendent);
        	backTracking(s, res, cur, startIndex+1,ipPart+1);
        	cur.delete(cur.length()-appendent.length(), cur.length());    		
    	}

    	if(startIndex+1<s.length()){
        	int twoDig = Integer.valueOf(s.substring(startIndex, startIndex+2));
        	if(twoDig>=10 && twoDig<=99){
        		String appendent = cur.length()==0? String.valueOf(twoDig) :"." + String.valueOf(twoDig);
            	cur.append(appendent);
            	backTracking(s, res, cur, startIndex+2,ipPart+1);
            	cur.delete(cur.length()-appendent.length(), cur.length());       		
        	}    		
    	}

 	
    	if(startIndex+2<s.length()){
        	int threeDig = Integer.valueOf(s.substring(startIndex, startIndex+3));
        	if(threeDig>=100 && threeDig<=255){
        		String appendent = cur.length()==0? String.valueOf(threeDig) :"." + String.valueOf(threeDig);
            	cur.append(appendent);
            	backTracking(s, res, cur, startIndex+3,ipPart+1);
            	cur.delete(cur.length()-appendent.length(), cur.length());  
        	}    		
    	}

    	
    }
}
