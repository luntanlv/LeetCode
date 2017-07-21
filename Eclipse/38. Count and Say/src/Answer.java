
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        String res = answer.countAndSay(5);
        System.out.println(res);    
	}
	
    public String countAndSay(int n) {
        String s = "1";        
        for(int i=1; i<n; i++){
        	char[] ch = s.toCharArray();
        	
        	char pre= ch[0];
        	int count=1;
        	StringBuilder sb = new StringBuilder();	
        	
        	for(int j=1; j<=ch.length; j++){
        		char cur = j<ch.length?ch[j]:'0';
        		if(pre!=cur){
        			sb.append((char)(count+'0'));
        			sb.append(pre);
        			count=1;
        		}
        		else
        			count++;
        		pre=cur;
        	}
        	s= sb.toString();
        }
        return s;
    }
}
