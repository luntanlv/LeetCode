import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        boolean res = answer.isPalindrome(1234321);
        System.out.println(res);       
	}
	
    public boolean isPalindrome(int x) {
        if(x < 0 || (x>0 && x%10==0))
        	return false;
        
        int res=0;
        while(x/10>res) {
        	res = res*10 + x%10;
        	x/=10;
        }
        
        return res==x || res ==x/10;
    }
}
