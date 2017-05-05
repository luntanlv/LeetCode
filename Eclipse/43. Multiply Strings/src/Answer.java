import java.util.ArrayList;

public class Answer {

	public static void main(String [] args)
	{
        Answer answer = new Answer();
        System.out.println();
	}
	
    public String multiply(String num1, String num2) {
    	String res = "";
        for(int i=num1.length()-1; i>=0 ;i--){
        	int a = num1.charAt(i)-'0';
        	int carryOver = 0;
        	StringBuilder tempResBuilder = new StringBuilder();
        	for(int j=num2.length(); j>=0;j--){
        		int b = num2.charAt(j)-'0';
        		int temp = a*b + carryOver;
        		carryOver = temp/10;
        		int d = temp%10;
        		
        		tempResBuilder.append(Integer.toString(d));
        	}   	
        	
        	tempResBuilder =  tempResBuilder.reverse();
        	for(int l=0; i<num1.length() -i ;i++){
        		tempResBuilder.append('0');
        	}
        	String tempRes = tempResBuilder.toString();
        	StringBuilder resBuilder = new StringBuilder();
        	
        	for(int k=tempRes.length()-1; k>=0; ){
        		int e=0;
        		if(k<res.length())
        			int e = res.charAt(k)-'0';
        		
        			int f = tempRes.
        	}
        	
        }
    }
	
}
