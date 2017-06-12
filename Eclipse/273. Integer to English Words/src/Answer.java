
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        String res = answer.numberToWords(1000010);
        System.out.println(res);       
	}
	
    public String numberToWords(int num) {
    	if(num==0)
    		return "Zero";
    	
    	String[] _3digitDic = new String[]{"", " Thousand", " Million", " Billion"};
    	
    	StringBuilder sb = new StringBuilder();
    	int _3digitCount =0;
    	while(num>0){
    		int _3digit = num%1000;
    		String _3digitStr = _3digitToWords(_3digit);
    		if(_3digitStr.length()>0){
        		sb.insert(0, _3digitStr + _3digitDic[_3digitCount] + (sb.length()==0? "": " "));    			
    		}
    		
    		num/=1000;
    		_3digitCount++;
    	}

    	return sb.toString();
    }
    
    private String _3digitToWords(int _3digit){
    	StringBuilder sb = new StringBuilder();
    	
    	String[] _1digitDic = new String[] {"Zero~~~","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    	String[] _2digitDic = new String[] {"Zero~~~","One~~~","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    	String[] _10sDic = new String[] {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    	
    	boolean is_10s = false;
    	for(int i=2; i>=0; i--){
    		int digit = _3digit / (int)(Math.pow(10, i)) % 10;	
    		
    		switch(i){
    			case 2:
    	    		if(digit == 0)
    	    			continue;	
    				sb.append(_1digitDic[digit]+ " Hundred");
    				break;
    			case 1:
    	    		if(digit == 0)
    	    			continue;	
    				
    				if(digit ==1){
    					is_10s = true;
    				}
    				else{
    					sb.append((sb.length()==0? "": " ")  + _2digitDic[digit]);
    				}
    				break;
    			case 0:
    				if(is_10s){
    					sb.append((sb.length()==0? "": " ")  + _10sDic[digit]);
    				}
    				else{
        	    		if(digit == 0)
        	    			continue;	
    					sb.append((sb.length()==0? "": " ")  + _1digitDic[digit]);
    				}
    				
    		}
    			 		
    	}
    	
    	return sb.toString();
    }
}
