import java.util.ArrayList;

public class Answer {

	public static void main(String [] args)
	{
        Answer answer = new Answer();
        String res = answer.multiply("00","990");
        System.out.println(res);
	}
	
	
	//LeetCode have better solution
    public String multiply(String num1, String num2) {
    	StringBuilder res = new StringBuilder();
        for(int i=num1.length()-1; i>=0 ;i--){
        	int a = num1.charAt(i)-'0';
        	int carryOver = 0;
        	StringBuilder tempResBuilder = new StringBuilder();
        	
        	for(int j=0; j<num1.length()-i-1 ;j++){
        		tempResBuilder.append('0');
        	}        	
        	
        	for(int j=num2.length()-1; j>=0;j--){
        		int b = num2.charAt(j)-'0';
        		int temp = a*b + carryOver;
        		carryOver = temp/10;
        		int d = temp%10;
        		
        		tempResBuilder.append(Integer.toString(d));
        	}   	
        	if(carryOver>0)
        		tempResBuilder.append(Integer.toString(carryOver));
        	
        	StringBuilder resBuilder = new StringBuilder();
        	
        	int g=0;
        	for(int k=0; k<tempResBuilder.length(); k++){
        		int e = tempResBuilder.charAt(k)-'0';
        		int f = k<res.length()? res.charAt(k)-'0': 0;
        		
        		int temp = e+f+g;
        		g=temp/10;
        		int h = temp%10;
        		resBuilder.append(Integer.toString(h));    		
        	}
        	
        	if(g>0)
        		resBuilder.append(Integer.toString(g));       	
        	
        	res= resBuilder;  	
        }
        
        String resString = res.reverse().toString();
        boolean allZero = true;
        for(int i=0; i<resString.length();i++){
        	if(resString.charAt(i)!='0'){
        		allZero = false;
        		break;
        	}
        }
        
        if(allZero)
        	return "0";
        return resString;
    }
	
}
