import java.util.HashMap;

public class Answer {

	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int res = answer.romanToInt_reverse("XIX");
        System.out.println(res);       
	}
	
	//the first smaller than the next is only happen in 4(IV) and 9(IX)... there is no things like IIV
    public int romanToInt(String s) {
        HashMap<Character, Integer> dic = new HashMap<>();
        dic.put('I', 1);
        dic.put('V', 5);
        dic.put('X', 10);
        dic.put('L', 50);
        dic.put('C', 100);
        dic.put('D', 500);
        dic.put('M', 1000);
        
        char[] sChr = s.toCharArray();
        int sum =0;
        
        for(int i=0; i<sChr.length;){
        	int cur = dic.get(sChr[i]);
        	int next = i+1 < sChr.length? dic.get(sChr[i+1]) : 0;
        	if(cur >= next){
        		sum+=cur;
        		i++;
        	}
        	//cur<next
        	else{
        		sum+=next-cur;
        		i+=2;
        	}
        }
        return sum;
    }
    
    //The reason to reserve is that XIX, I belong to second X in Roman word, instead of first one. 
    //Which means the second X has higher priority than the first, so reverse will handle this automatically
    public int romanToInt_reverse(String s) {
        HashMap<Character, Integer> dic = new HashMap<>();
        dic.put('I', 1);
        dic.put('V', 5);
        dic.put('X', 10);
        dic.put('L', 50);
        dic.put('C', 100);
        dic.put('D', 500);
        dic.put('M', 1000);
        
        char[] sChr = s.toCharArray();
        int sum =0, pre =0;
        
        for(int i=sChr.length-1; i>=0 ; i--){
        	int cur = dic.get(sChr[i]);
        	if(cur >= pre){
        		sum+=cur;
        	}
        	//cur<pre
        	else{
        		sum-=cur;
        	}
        	
        	pre=cur;
        }
        return sum;
    }
	
}
