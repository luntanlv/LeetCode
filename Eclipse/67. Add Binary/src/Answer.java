
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        String res = answer.addBinary("0","0");
        System.out.println(res);
	}
	
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        
        int i=s1.length-1, j=s2.length-1;
        int c=0;
        while(i>=0 || j>=0){
        	int v1=i>=0? s1[i--]-'0' : 0;
        	int v2=j>=0? s2[j--]-'0' : 0;
        	int res = v1+v2+c;
        	sb.insert(0,String.valueOf(res%2));
        	c = res/2;
        }
        if(c>0)
        	sb.insert(0,"1");
        return sb.toString();
    }
}
