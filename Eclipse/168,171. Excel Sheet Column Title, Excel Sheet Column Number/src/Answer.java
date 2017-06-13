
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int res = answer.titleToNumber("AB");
        String res2 = answer.convertToTitle(27);
        System.out.println(res2);       
	}
	
	//168
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
        	n--;
        	int curNum = n%26;
        	sb.insert(0, (char)('A'+curNum));
        	
        	n/=26;
        }
        
        return sb.toString();
    }
	
	//171
    public int titleToNumber(String s) {
        int res =0;
        for(int i=0; i<s.length(); i++){
        	char cur = s.charAt(i);
        	int curNum = cur - 'A' +1;
        	res = res*26 +curNum;
        }
        return res;
    }
}
