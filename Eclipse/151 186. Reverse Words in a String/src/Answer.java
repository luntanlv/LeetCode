
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        String input = "the sky is blue";
        String res =answer.reverseWords(input);
        
        char[] input2 = input.toCharArray();
        answer.reverseWords(input2);
        System.out.println(input2);       
	}
	
	//151
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
    
    //186
    public void reverseWords(char[] s) {
        //First reverse whole string
    	reverse(s, 0, s.length-1);
    	
//    	//reverse each word
//        int start = 0;
//        int end = -1;
//        for (int i = 0; i < s.length; i++) {
//            if (s[i] == ' ') {
//                reverse(s, start, i - 1);
//                start = i + 1;
//            }
//        }
//        //reverse the last word, if there is only one word this will solve the corner case
//        reverse(s, start, s.length - 1);
    	
    	//reverse each word
    	int start=0, end=0;
    	while(start<s.length){
    		while((start<s.length && s[start] == ' ') || start < end){
    			start++;
    		}
    		while((end<s.length && s[end] != ' ') || start > end){
    			end++;
    		}
    		reverse(s, start, end-1);
    	}
    }
    
    private void reverse(char[] s, int l, int r){
    	while(l<r){
    		char temp = s[l];
    		s[l]=s[r];
    		s[r]=temp;
    		l++;
    		r--;
    	}
    }
}
