

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int res = answer.firstUniqChar("");
        System.out.println(res);       
	}
	
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] sChr = s.toCharArray();
        for(char val : sChr){
        	int index = val -'a';
        	count[index]++;
        }
        
        for(int i=0; i<sChr.length; i++){
        	if(count[sChr[i]-'a']==1)
        		return i;
        }
        return -1;
    }
}
