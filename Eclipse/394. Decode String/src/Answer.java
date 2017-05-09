import java.util.Stack;

public class Answer {

	public static void main(String [] args)
	{
        Answer answer = new Answer();
        String res = answer.decodeString("ss3[a2[c]]");
        System.out.println(res);
	}
	
	
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<Integer>();
        Stack<String> strSt = new Stack<String>();
       
        strSt.push("");
        
        int curNum =0;
        for(int i =0; i<s.length();i++){
        	if(s.charAt(i)>='0' && s.charAt(i)<='9'){
        		curNum=curNum*10+s.charAt(i)-'0';;
        	}
        	else if(s.charAt(i)=='['){
        		numSt.push(curNum);
        		strSt.push("");
        		curNum=0;
        	}
        	else if(s.charAt(i)==']'){
        		int num = numSt.pop();
        		
        		String current = strSt.pop();
        		StringBuilder temp = new StringBuilder();
        		for(int j=0; j<num; j++){
        			temp.append(current);
        		}
        		current = temp.toString();
        		
        		current = strSt.pop() + current;
        		strSt.push(current);
        	}
        	//a-z, A-Z
        	else{
        		String current = strSt.pop();
        		current = current + s.charAt(i);
        		strSt.push(current);
        	}
        }
        return strSt.peek();
    }
}
