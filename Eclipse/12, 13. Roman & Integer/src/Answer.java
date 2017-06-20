import java.util.HashMap;

public class Answer {

	
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        //int res = answer.romanToInt_reverse("XIX");
        String res = answer.intToRoman(9);
        System.out.println(res);       
	}
	
	//12. Integer to Roman
	//I saw the solution
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();    	
    	
//        int[] dividorList = new int[]{1000, 500, 100, 50, 10, 5, 1};
//        HashMap<Integer, Character> dic = new HashMap<>();
//        dic.put(1, 'I');
//        dic.put(5, 'V');
//        dic.put(10, 'X');
//        dic.put(50, 'L');
//        dic.put(100, 'C');
//        dic.put(500, 'D');
//        dic.put(1000, 'M');
//        
//        StringBuilder res = new StringBuilder();
//        for(int i=0; i<dividorList.length; i++){
//        	int dividor = dividorList[i];
//        	
//        	int cur = num / dividor;
//        	if(cur>0 && cur<=3){
//        		for(int j=0; j<cur; j++){
//        			res.append(dic.get(dividor));
//        		}
//        	}
//        	else if(cur>3 && cur<5){
//        		for(int j=0; j<5-cur; j++){
//        			res.append(dic.get(dividor));
//        		}
//        		if(i-1>0)
//        			res.append(dic.get(dividorList[i-1]));
//        	}
//        	
//        	num=num%dividor;
//        }
//        
//        return res.toString();
    }
	
	
	
	//--------------------------------------------------------------------------------------------------------------
	//13 Roman to Integer
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
