
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        boolean res = answer.isPalindrome(".,");
        System.out.println(res);       
	}
	
    public boolean isPalindrome(String s) {
    	s=s.toLowerCase();
        int left=0, right =s.length()-1;
        while(left<right){
        	while(left<s.length() && !( (s.charAt(left)>='a' && s.charAt(left) <='z') || (s.charAt(left)>='0' && s.charAt(left) <='9') ) ){
        		left++;
        	}
        	
        	while(right>0 && !( (s.charAt(right)>='a' && s.charAt(right) <='z') || (s.charAt(right)>='0' && s.charAt(right) <='9') ) ){
        		right--;
        	}
        	
        	if(left< right && s.charAt(left) != s.charAt(right))
        		return false;
        	
        	left++;
        	right--;
        }
        return true;
        
    }
    
    public boolean isPalindrome_consice(String s) {
    	s=s.toLowerCase();
        int left=0, right =s.length()-1;
        while(left<right){
        	if(!Character.isLetterOrDigit(s.charAt(left)))
        		left++;
        	
        	else if(!Character.isLetterOrDigit(s.charAt(right)))
        		right--;
        	
        	else{
            	if(left< right && s.charAt(left) != s.charAt(right))
            		return false;
            	
            	left++;
            	right--;
        	}

        }
        return true;
        
    }
}
