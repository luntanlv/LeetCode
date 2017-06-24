
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        //int res =answer.myAtoi("2147483648");
        //int res =answer.myAtoi("-2147483647");
        int res =answer.myAtoi("-+1");
        System.out.println(res);       
	}
	
	//I will skip all invalid char before number or sign, like ' b1'->1
    public int myAtoi_2(String str) {
        int sign =1;
        boolean isStart = false;
        char[] strChr = str.toCharArray();
        
        int temp =0;
        for(int i=0; i<strChr.length; i++){
        	char cur = strChr[i];
        	if((cur<'0' || cur>'9') && cur != '-' && cur != '+'){
        		if(!isStart)
        			continue;
        		else
        			break;
        	}
        	
        	if(cur == '-' || cur == '+'){
        		if(!isStart){
            		isStart = true;
            		sign = cur == '-'? -1 :1;
        		}
        		else
        			break;

        	}   	
        	else if(cur>='0' && cur<='9'){
        		isStart = true;
        		if(temp>Integer.MAX_VALUE/10 || cur-'0'>Integer.MAX_VALUE - temp*10 )
        			return sign ==1? Integer.MAX_VALUE : Integer.MIN_VALUE;
        		
        		temp=temp*10 + (cur-'0'); 
        	}
        }
        
        return temp*sign;
    }
    
    //only allow empty space before number or sign, like ' b1'->0
    public int myAtoi(String str) {
        int sign =1;
        boolean isStart = false;
        char[] strChr = str.toCharArray();
        
        int temp =0;
        for(int i=0; i<strChr.length; i++){
        	char cur = strChr[i];
        	
        	if(cur<'0' || cur>'9'){
        		if(!isStart && cur == ' ')
        			continue;
        		else if(!isStart && (cur == '-' || cur == '+')){
            		isStart = true;
            		sign = cur == '-'? -1 :1;
            		continue;
        		}
        		else
        			break;
        	}
        	
        	else{
        		isStart = true;
        		if(temp>Integer.MAX_VALUE/10 || cur-'0'>Integer.MAX_VALUE - temp*10 )
        			return sign ==1? Integer.MAX_VALUE : Integer.MIN_VALUE;
        		
        		temp=temp*10 + (cur-'0'); 
        	}
        }
        
        return temp*sign;
    }

}
