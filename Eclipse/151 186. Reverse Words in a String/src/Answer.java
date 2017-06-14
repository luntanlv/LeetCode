
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        String res =answer.reverseWords("a");
        System.out.println(res);       
	}
	
    public String reverseWords(String s) {
    	StringBuilder sb = new StringBuilder();
    	boolean hasWord = false;
    	
        for(int i=0, pre=0; i<=s.length(); i++){
        	if(i == s.length() || s.charAt(i) == ' '){
        		if(hasWord){
        			String target = sb.length()==0? s.substring(pre, i) : s.substring(pre, i) + " ";
        			sb.insert(0, target);
        			hasWord = false;			
        		}
        	}
        	else{
        		if(!hasWord){
        			hasWord = true;
        			pre=i;
        		} 		
        	}
        }
        
        return sb.toString();
    }
}
